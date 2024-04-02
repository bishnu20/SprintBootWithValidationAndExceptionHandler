package com.bhusal;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhusal.entity.Employee;
import com.bhusal.service.impl.EmployeeSerImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private final EmployeeSerImpl employeeSerImpl;

	public EmployeeController(EmployeeSerImpl employeeSerImpl) {
		super();
		this.employeeSerImpl = employeeSerImpl;
	}
	
	// add employ into the database
	@PostMapping("/addEmp")
	public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee emp){
		Employee employee =  employeeSerImpl.addEmployee(emp);
		return ResponseEntity.ok(employee);
	}
	
	@GetMapping("/employees") // the end point /employees is optional.
	public List<Employee> getAllEmployees(){
		return employeeSerImpl.showAllEmployee();
	}
	
	// find employee by id
	@GetMapping("/{eid}")
	public Employee getEmpById(@PathVariable Long eid) {
		return employeeSerImpl.getEmployeeById(eid);
	}
	
	// delete employee based on id
	@DeleteMapping("/{eid}")
	public ResponseEntity<?> deleteEmp(@PathVariable Long eid){
		employeeSerImpl.deleteEmployee(eid);
		return ResponseEntity.ok().build();
	}
	
	

}
