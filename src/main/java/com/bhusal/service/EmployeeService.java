package com.bhusal.service;

import java.util.List;

import com.bhusal.entity.Employee;

public interface EmployeeService {
	public Employee getEmployeeById(Long eid);
	public List<Employee> showAllEmployee();
	public Employee addEmployee(Employee emp);
	public void deleteEmployee(Long id);

}
