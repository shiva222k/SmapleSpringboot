package com.hackerrank.sample.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hackerrank.sample.model.Employee;
import com.hackerrank.sample.repository.EmployeeRepository;

@Component
public class EmployeeJsonConverter {

	@Autowired
	EntityManager em;

	EmployeeRepository emprepo = new EmployeeRepository();

	@Transactional
	public void convertJsonAndSave() {
		List<Employee> empList = new ArrayList();
		JSONParser jsonParser = new JSONParser();
		try (FileReader reader = new FileReader("src/test/resources/employees.json")) {
			Object obj = jsonParser.parse(reader);
			JSONObject jsonObj = (JSONObject) obj;
			JSONArray jsonArray = (JSONArray) jsonObj.get("employees");
			for (Object employee : jsonArray) {
				JSONObject o = (JSONObject) employee;
				Long id = (Long) o.get("id");
				String name = (String) o.get("name");
				Employee emp = new Employee(id, name);
				empList.add(emp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (Employee emp : empList) {
			em.persist(emp);
		}
	}
}
