package com.hackerrank.sample.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hackerrank.sample.exception.BadResourceRequestException;
import com.hackerrank.sample.exception.NoSuchResourceFoundException;
import com.hackerrank.sample.model.Employee;

@Transactional
@Repository
public class EmployeeRepository {

	@Autowired
	EntityManager em;

	public Employee findById(Long id) {
		Employee emp = em.find(Employee.class, id);
		if (emp == null)
			throw new NoSuchResourceFoundException("No Such Id");
		return emp;
	}

	public Employee save(Employee emp) {
		Employee employee = em.find(Employee.class,emp.getId());
		if (employee==null) {
			em.persist(emp);
			return emp;
		} else {
			throw new BadResourceRequestException("dublicate id");
		}
	}

	public void deleteById(Long id) {
		Employee emp = findById(id);
		em.remove(emp);
	}

	public void deleteall() {
		em.createNativeQuery("delete from employee").executeUpdate();
	}

	public List<Employee> findall() {
		return em.createNativeQuery("select * from EMPLOYEE ",Employee.class).getResultList();
	}

}
