package com.waytosuccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waytosuccess.entity.Employee;

@Repository
public interface EmployeeRepoditory extends JpaRepository<Employee,Integer> {

	
}
