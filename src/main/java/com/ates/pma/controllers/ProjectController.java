package com.ates.pma.controllers;

import com.ates.pma.dao.EmployeeRepository;
import com.ates.pma.dao.ProjectRepository;
import com.ates.pma.entities.Employee;
import com.ates.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects = projectRepo.findAll();
        model.addAttribute("projects",projects);

        return "projects/list-projects";
    }

    @RequestMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        List<Employee> employees =  empRepo.findAll();
        model.addAttribute("allEmployees",employees);
        return  "projects/new-project";

    }
    @PostMapping("/save")
    public String createProject(Project project, Model model){
        projectRepo.save(project);

        return "redirect:/projects";
//
        }


    }



