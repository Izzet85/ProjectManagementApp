package com.ates.pma.dao;

import com.ates.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

 public interface EmployeeRepository extends CrudRepository<Employee,Long>
{

}