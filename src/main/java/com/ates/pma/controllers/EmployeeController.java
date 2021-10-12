package com.ates.pma.controllers;


import com.ates.pma.dao.EmployeeRepository;
import com.ates.pma.entities.Employee;
import com.ates.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepo;



    @GetMapping
    public String displayEmployees(Model model){
        List<Employee> employees = employeeRepo.findAll();
        model.addAttribute("employee",employees);
        return "employees/list-employees";
    }


    @RequestMapping("/new")
    public String displayEmployeeForm  (Model model){
        Employee aEmployee = new Employee();
        model.addAttribute("employee", aEmployee);

        return "employees/new-employee";

    }

    @PostMapping("/save")
    public String createEmployee(Employee employee,Model model){
        employeeRepo.save(employee);

        return "redirect:/employees/new";

    }


}
