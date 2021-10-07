package com.ates.pma.dao;

import com.ates.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long>
{
 @Override
 public List<Employee> findAll();

}