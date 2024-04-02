package com.bhusal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bhusal.entity.Employee;
import com.bhusal.exception.EmployeeException;
import com.bhusal.repo.EmployeeRepo;
import com.bhusal.service.EmployeeService;

@Service
public class EmployeeSerImpl implements EmployeeService {
	
	// create a variable of EmployeeRepo
	 EmployeeRepo employeeRepo;
	
	// create a contructor to use constructor injection
	 
	 public EmployeeSerImpl(EmployeeRepo employeeRepo) {
			super();
			this.employeeRepo = employeeRepo;
		}
	 
	 @Override
		public Employee addEmployee(Employee emp) {
			return employeeRepo.save(emp);		
		}
	 
	@Override
	public Employee getEmployeeById(Long eid) {
		
		 Optional<Employee> optional = employeeRepo.findById(eid);
		 if(!optional.isPresent()) {
			 throw new EmployeeException(eid);
		 }
		 return optional.get();
	}


	@Override
	public List<Employee> showAllEmployee() {	
		return employeeRepo.findAll();
	}

	

	@Override
	public void deleteEmployee(Long eid) {
		 Optional<Employee> optional = employeeRepo.findById(eid);
		 if(!employeeRepo.existsById(eid)) {
			 throw new EmployeeException(eid);
		 }
		employeeRepo.deleteById(eid);
	}

	

}
