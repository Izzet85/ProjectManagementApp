package com.ates.pma.controllers;


import com.ates.pma.dao.EmployeeRepository;
import com.ates.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepo;


    @RequestMapping("/new")
    public String displayEmployeeForm  (Model model){
        Employee aEmployee = new Employee();
        model.addAttribute("employee", aEmployee);

        return "new-employee";

    }

    @PostMapping("/save")
    public String createEmployee(Employee employee,Model model){
        employeeRepo.save(employee);

        return "redirect:/employee/new";

    }


}