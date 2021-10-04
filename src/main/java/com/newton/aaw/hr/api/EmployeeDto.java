package com.newton.aaw.hr.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.newton.aaw.hr.domain.entity.Employee;
import com.newton.aaw.hr.domain.entity.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private String id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private Gender gender;
	private LocalDate startDate;
	private LocalDate endDate;
	private String position;
	private Float monthlySalary;
	private Float hourSalary;
	private String area;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	public EmployeeDto(Employee e) {
		this.id = e.getId();
		this.firstName = e.getFirstName();
		this.lastName = e.getLastName();
		this.dateOfBirth = e.getDateOfBirth();
		this.gender = e.getGender();
		this.startDate = e.getStartDate();
		this.endDate = e.getEndDate();
		this.position = e.getPosition();
		this.monthlySalary = e.getMonthlySalary();
		this.hourSalary = e.getHourSalary();
		this.area = e.getArea();
		this.createdAt = e.getCreatedAt();
		this.modifiedAt = e.getModifiedAt();
	}
	
}