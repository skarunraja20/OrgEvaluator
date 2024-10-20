package com.swissre.assignment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;


public class OrgEvaluatorTest {

    private OrgEvaluator orgEvaluator;
    private HashMap<Integer, Employee> employeesMap;

    @Before
   public void setUp() {
        orgEvaluator = new OrgEvaluator();
        employeesMap = new HashMap<>();
        employeesMap.put(1, new Employee(1, "Kumar", "Singh", 100000, null));
        employeesMap.put(2, new Employee(2, "Aswin", "Kumar", 80000, 1));
        employeesMap.put(3, new Employee(3, "Virat", "Kohli", 60000, 1));
        employeesMap.put(4, new Employee(4, "Rohit", "Sharma", 40000, 2));
    }

    @Test
   public void testConstructEmployeesHierarchy() {
        Employee ceo = orgEvaluator.constructEmployeesHierarchy(employeesMap);
        assertNotNull(ceo);
        assertEquals("Kumar", ceo.getFirstname());
        assertEquals(2, ceo.getSubordinates().size());
        assertEquals("Aswin", ceo.getSubordinates().get(0).getFirstname());
        assertEquals(1, ceo.getSubordinates().get(0).getSubordinates().size());
        assertEquals("Rohit", ceo.getSubordinates().get(0).getSubordinates().get(0).getFirstname());
    }

    @Test
   public void testEvaluateSalaries() {
        Employee ceo = orgEvaluator.constructEmployeesHierarchy(employeesMap);
        List<String> lessEarningMgrList = new ArrayList<>();
        List<String> moreEarningMgrList = new ArrayList<>();
        orgEvaluator.evaluateSalaries(ceo, lessEarningMgrList, moreEarningMgrList);
        assertEquals(0, lessEarningMgrList.size());
        assertEquals(1, moreEarningMgrList.size());
        assertTrue(moreEarningMgrList.get(0).contains("Aswin Kumar with emp id - 2 is earning more by "));
    }

    @Test
   public void testEvaluateReportingHierarchy() {
        Employee ceo = orgEvaluator.constructEmployeesHierarchy(employeesMap);
        List<String> longReportingHierarchyEmpList = new ArrayList<>();
        orgEvaluator.evaluateReportingHierarchy(ceo, 0, longReportingHierarchyEmpList);
        assertEquals(0, longReportingHierarchyEmpList.size());
    }
}

