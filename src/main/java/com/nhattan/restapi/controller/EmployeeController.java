package com.nhattan.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhattan.restapi.dto.EmployeeDTO;
import com.nhattan.restapi.service.IEmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/employee")
	public List<EmployeeDTO> showAll() {
		return employeeService.showAll();
	}

	@GetMapping("/employee/{employeeID}")
	public EmployeeDTO showOne(@PathVariable("employeeID") int employeeID) {
		return employeeService.showOneByEmployeeID(employeeID);
	}

	@PostMapping("/employee")
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return employeeService.saveEmployee(employeeDTO);
	}

	@DeleteMapping("/employee/{employeeID}")
	public String deleteEmployee(@PathVariable("employeeID") int employeeID) {
		return employeeService.deleteEmployeeByEmployeeID(employeeID);
	}

	@PutMapping("/employee")
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return employeeService.updateEmployee(employeeDTO);
	}

}
