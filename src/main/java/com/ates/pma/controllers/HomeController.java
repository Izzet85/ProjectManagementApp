package com.ates.pma.controllers;


import com.ates.pma.dao.EmployeeRepository;
import com.ates.pma.dao.ProjectRepository;
import com.ates.pma.entities.Employee;
import com.ates.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/home")
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model){
      List<Project> projects =  proRepo.findAll();

      model.addAttribute("projects",projects);
        List<Employee> employees =  employeeRepo.findAll();

        model.addAttribute("employees",employees);
        return "main/home";

    }

}
