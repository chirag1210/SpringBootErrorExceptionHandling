package com.chirag.exceptionhandling.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chirag.exceptionhandling.entities.Employee;
import com.chirag.exceptionhandling.error.CustomException;
import com.chirag.exceptionhandling.serviceImpl.EmployeeService;
import com.chirag.exceptionhandling.validationUtil.EmployeeRequestValidationUtil;

@RestController
public class EmployeeComponent {

	@Autowired
	EmployeeService employeeService;


	@Autowired
	EmployeeRequestValidationUtil validationUtil;
	
	@PostMapping(value = "/employee")
	public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee) {

		employeeService.createEmployee(employee);
		return new ResponseEntity<Object>("Successfully Saved", HttpStatus.OK);
	}

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Object> getEmployee(@PathVariable Long id) throws CustomException {

		validationUtil.validateEmployeeId(id);
		Employee employee = employeeService.getEmployeeById(id);
		return new ResponseEntity<Object>(employee, HttpStatus.OK);
	}

}
