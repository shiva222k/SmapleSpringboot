package com.hackerrank.sample.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import com.hackerrank.sample.model.Employee;
import com.hackerrank.sample.model.Model;

public class ModelServiceImpl implements ModelService {

	@Override
	public void deleteAllModels() {
		
	}

	@Override
	public void deleteModelById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createModel(Model model) {
		
		
	}
	
	
	@Override
	public Model getModelById(Long id) {
		List<Employee> empList= new ArrayList();
		JSONParser parser = new JSONParser();
        try {     
            Object obj = parser.parse(new FileReader("employees.json"));
            JSONArray jsonArray = (JSONArray) obj;
            for(Object object: jsonArray) {	
            	JSONObject employee = (JSONObject) object;
            	String name = (String) employee.get("name");
                int age=(int) employee.get("age");
                Date dob=(Date) employee.get("dob");
                empList.add(new Employee(name,age,dob));
            }
            
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
        return null;
	}

	@Override
	public List<Model> getAllModels() {
		
		return null;
	}

}
