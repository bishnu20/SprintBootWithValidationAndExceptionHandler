package com.bhusal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhusal.entity.Employee;

@Repository // This is optional
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
