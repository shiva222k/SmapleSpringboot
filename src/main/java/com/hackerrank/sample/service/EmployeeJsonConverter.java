package com.hackerrank.sample.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import com.hackerrank.sample.model.Employee;

public class EmployeeJsonConverter {
	List<Employee> empList = new ArrayList();
	@Autowired
	Employee emp;

	public void convertJson() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("employees.json"));
			JSONArray jsonArray = (JSONArray) obj;
			for (Object object : jsonArray) {
				JSONObject employee = (JSONObject) object;
				String name = (String) employee.get("name");
				int age = (int) employee.get("age");
				Date dob = (Date) employee.get("dob");
				emp.setName(name);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
	}
}
