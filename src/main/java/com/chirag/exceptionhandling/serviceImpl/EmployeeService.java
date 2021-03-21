package com.chirag.exceptionhandling.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.chirag.exceptionhandling.entities.Employee;
import com.chirag.exceptionhandling.error.CustomException;
import com.chirag.exceptionhandling.repo.EmployeeRepository;
import com.chirag.exceptionhandling.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void createEmployee(Employee employee) {

		employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) throws CustomException{
		Employee empResponse = null;
		
		empResponse = employeeRepository.getEmbloyeById(id);

		if (empResponse == null) {
			throw new CustomException("Employee not found for given id " + id + "", HttpStatus.NOT_FOUND);
		}
		return empResponse;
	}

}
