package com.nhattan.restapi.service;

import java.util.List;

import com.nhattan.restapi.dto.EmployeeDTO;

public interface IEmployeeService {
	List<EmployeeDTO> showAll();
	EmployeeDTO showOneByEmployeeID(int employeeID);
	EmployeeDTO saveEmployee(EmployeeDTO employee);
	EmployeeDTO updateEmployee(EmployeeDTO employee);
	String deleteEmployeeByEmployeeID(int employeeID);
}
