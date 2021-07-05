package com.nhattan.restapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhattan.restapi.dto.EmployeeDTO;
import com.nhattan.restapi.entity.Employee;
import com.nhattan.restapi.exception.ConflictException;
import com.nhattan.restapi.exception.NotFoundException;
import com.nhattan.restapi.repository.IEmployeeRepository;
import com.nhattan.restapi.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<EmployeeDTO> showAll() {
		return employeeRepository.findAll().stream().map(x -> modelMapper.map(x, EmployeeDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO showOneByEmployeeID(int employeeID) {
		Employee employee = employeeRepository.findOne(employeeID);
		if (employee == null)
			throw new NotFoundException("employee-not-found");
		return modelMapper.map(employee, EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employee) {
		if (employeeRepository.existsEmployeeByEmail(employee.getEmail()))
			throw new ConflictException("email-already-used");
		Employee newEmployee = modelMapper.map(employee, Employee.class);
		int defaultEmployeeID = 0;
		newEmployee.setEmployeeID(defaultEmployeeID);
		return modelMapper.map(employeeRepository.save(newEmployee), EmployeeDTO.class);
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employee) {
		if (!employeeRepository.exists(employee.getEmployeeID()))
			throw new NotFoundException("employee-not-found");
		if (employeeRepository.existsEmployeeByEmailAndEmployeeIDNot(employee.getEmail(), employee.getEmployeeID()))
			throw new ConflictException("email-already-used");
		Employee newEmployee = modelMapper.map(employee, Employee.class);
		return modelMapper.map(employeeRepository.save(newEmployee), EmployeeDTO.class);
	}

	@Override
	public String deleteEmployeeByEmployeeID(int employeeID) {
		if (!employeeRepository.exists(employeeID))
			throw new NotFoundException("employee-not-found");
		employeeRepository.delete(employeeID);
		return "successfully";
	}
}
