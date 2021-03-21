package com.chirag.exceptionhandling.service;

import com.chirag.exceptionhandling.entities.Employee;
import com.chirag.exceptionhandling.error.CustomException;

public interface IEmployeeService {

	public void createEmployee(Employee employee);

	public Employee getEmployeeById(long id)throws CustomException;

}
