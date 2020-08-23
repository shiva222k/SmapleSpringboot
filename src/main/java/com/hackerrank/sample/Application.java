package com.hackerrank.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hackerrank.sample.service.EmployeeJsonConverter;

@SpringBootApplication
public class Application implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	EmployeeJsonConverter filldata;

	@Override
	public void run(String... args) throws Exception {
		filldata.convertJsonAndSave();
	}

}
