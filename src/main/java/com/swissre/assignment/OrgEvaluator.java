package com.swissre.assignment;

import java.util.HashMap;
import java.util.List;

public class OrgEvaluator {

	/* create employee hierarchy tree and return root node */
	Employee constructEmployeesHierarchy(HashMap<Integer, Employee> employeesMap) {
		Employee ceo = null;
		for (Employee emp : employeesMap.values()) {
			if (emp.getManagerId() != null) {
				Employee manager = employeesMap.get(emp.getManagerId());
				manager.addSubordinate(emp);
			} else {
				ceo = emp; // manager id will be empty for ceo
			}

		}
		return ceo;
	}

	void evaluateSalaries(Employee managerEmp, List<String> lessEarningMgrList, List<String> moreEarningMgrList) {
		if (managerEmp.getSubordinates().isEmpty())
			return;

		double totalSalary = 0;
		for (Employee emp : managerEmp.getSubordinates()) {
			totalSalary += emp.getSalary();
		}
		
		double avgSalary = totalSalary / managerEmp.getSubordinates().size();
		double minSalary = avgSalary * 1.2;
		double maxSalary = avgSalary * 1.5;

		if (managerEmp.getSalary() < minSalary) {
			lessEarningMgrList.add(managerEmp.getFirstname() + " " + managerEmp.getLastname() + " with emp id - "
					+ managerEmp.getId() + " is earning less by " + (minSalary - managerEmp.getSalary()));
		}
		
		if (managerEmp.getSalary() > maxSalary) {
			moreEarningMgrList.add(managerEmp.getFirstname() + " " + managerEmp.getLastname() + " with emp id - "
					+ managerEmp.getId() + " is earning more by " + (managerEmp.getSalary() - maxSalary));
		}

		for (Employee emp : managerEmp.getSubordinates()) {
			evaluateSalaries(emp, lessEarningMgrList, moreEarningMgrList);
		}
	}

	void evaluateReportingHierarchy(Employee employee, int depth, List<String> longReportingHierarchyEmpList) {
		if (depth > 4) {
			longReportingHierarchyEmpList.add(employee.getFirstname() + " " + employee.getLastname() + " with emp id - "
					+ employee.getId() + " has exceeding reporting hierarchy limit by " + (depth - 4));
		}

		for (Employee emp : employee.getSubordinates()) {
			evaluateReportingHierarchy(emp, depth + 1, longReportingHierarchyEmpList);
		}

	}
}
