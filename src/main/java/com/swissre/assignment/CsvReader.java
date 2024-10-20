package com.swissre.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CsvReader {

	private final String COMMA = ",";

	HashMap<Integer, Employee> getEmployeesMapFromFile(String csvFilePath) {
		String line;
		HashMap<Integer, Employee> employeesMap = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
			while ((line = br.readLine()) != null) {
				
				if (line.contains("salary") || line.contains("Salary"))
					continue; // skip headers if present
				
				String[] data = line.split(COMMA);
				int id = Integer.parseInt(data[0]);
				String firstname = data[1];
				String lastname = data[2];
				int salary = Integer.parseInt(data[3]);
				Integer managerId = data.length > 4 && !data[4].isEmpty() ? Integer.parseInt(data[4]) : null;

				Employee emp = new Employee(id, firstname, lastname, salary, managerId);
				employeesMap.put(id, emp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return employeesMap;
	}
}
