package com.nhattan.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhattan.restapi.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	Boolean existsEmployeeByEmail(String email);
	Boolean existsEmployeeByEmailAndEmployeeIDNot(String email, int employeeID);
}
