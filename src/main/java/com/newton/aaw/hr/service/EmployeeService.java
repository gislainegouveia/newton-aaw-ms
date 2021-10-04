package com.newton.aaw.hr.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newton.aaw.hr.domain.entity.Employee;
import com.newton.aaw.hr.domain.repository.EmployeeRepository;
import com.newton.aaw.hr.exception.NotFoundException;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee create(Employee e) {
		e.setCreatedAt(LocalDateTime.now());
		e.setModifiedAt(LocalDateTime.now());

		employeeRepository.save(e);
		
		return e;
	}
	
	public Employee update(String id, Employee e) {

		var existing = get(id);
		existing.setFirstName(e.getFirstName());
		existing.setLastName(e.getLastName());
		existing.setDateOfBirth(e.getDateOfBirth());
		existing.setGender (e.getGender());
		existing.setStartDate(e.getStartDate());
		existing.setEndDate(e.getEndDate());
		existing.setPosition(e.getPosition());
		existing.setMonthlySalary(e.getMonthlySalary());
		existing.setHourSalary(e.getHourSalary());
		existing.setArea(e.getArea());
		
		existing.setModifiedAt(LocalDateTime.now());
		employeeRepository.save(existing);
		return existing;
	}
	
	public Employee get(String id) {
		var employee = employeeRepository.findById(id);
		if (employee.isEmpty()) {
			throw new NotFoundException("Employee with ID " + id + " not found");
		} 
		return employee.get();
	}
	
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	public void delete(String id) {
		get(id);
		employeeRepository.deleteById(id);
	}
	
}