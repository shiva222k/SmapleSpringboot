package com.hackerrank.sample.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hackerrank.sample.model.Employee;
import com.hackerrank.sample.repository.EmployeeRepository;

@RestController
public class EmployeeServiceImpl {

	@Autowired
	EmployeeRepository empRepo;
	
	@DeleteMapping("/erase")
	public void deleteAllModels() {
		empRepo.deleteall();
	}

	@DeleteMapping("/model/{id}")
	public void deleteModelById(@PathVariable Long id) {
		empRepo.deleteById(id);
	}
	
	@PostMapping("/model")
	public ResponseEntity<Object> createModel(@RequestBody Employee emp) {
		Employee savedemp= empRepo.save(emp);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedemp.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/model/{id}")
	public Employee getModelById(@PathVariable Long id) {
		return empRepo.findById(id);
	}

	@GetMapping("/model")
	public List<Employee> getAllModels() {
		return empRepo.findall();
	}

}
