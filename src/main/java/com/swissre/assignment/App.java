package com.swissre.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class App 
{
	public static void main( String[] args )
	{
		String csvFilePath="C:\\Arun\\softwares\\employees_list.csv";
		Employee ceo = null;
		List<String> lessEarningMgrList = new ArrayList<String>();
		List<String> moreEarningMgrList = new ArrayList<String>();
		List<String> longReportingHierarchyEmpList = new ArrayList<String>();
		CsvReader csvReader = new CsvReader();
		OrgEvaluator orgEvaluator = new OrgEvaluator();
		
		
		HashMap<Integer,Employee> employeesMap = csvReader.getEmployeesMapFromFile(csvFilePath);
		ceo = orgEvaluator.constructEmployeesHierarchy(employeesMap); //get root node
		orgEvaluator.evaluateSalaries(ceo, lessEarningMgrList, moreEarningMgrList);
		orgEvaluator.evaluateReportingHierarchy(ceo, 0, longReportingHierarchyEmpList);
		

        System.out.println("Less Earning Managers:");
        printList(lessEarningMgrList);

        System.out.println("\nMore Earning Managers:");
        printList(moreEarningMgrList);

        System.out.println("\nEmployees with more than 4 Reporting Managers:");
        printList(longReportingHierarchyEmpList);
        
	}

	private static void printList(List<String> list) {
		for(String ln:list)
			System.out.println(ln);
	}


}
