package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.model.EmployeeGroup;
import com.codegym.service.EmployeeGroupService;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeGroupService employeeGroupService;
    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute("employeegroup")
    public Iterable<EmployeeGroup> employeeGroups() {
        return employeeGroupService.findAll();
    }


    // show list
    @GetMapping(value = "/list", produces = "application/json;charset=UTF-8")
    public ModelAndView listEmployee(@RequestParam("s") Optional<String> s, Pageable pageable) {
        Page<Employee> employees;
        if (s.isPresent()) {
            employees = employeeService.findAllByNameContaining(s.get(), pageable);
        } else {
            employees = employeeService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        return modelAndView;

    }

    // create
    @GetMapping(value = "/create-employee", produces = "application/json;charset=UTF-8")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public ModelAndView saveCreateNote(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/employee/create");
            return modelAndView;
        } else {
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView("/employee/create");
            modelAndView.addObject("employee", new Employee());
            modelAndView.addObject("message", "create employee was success");
            return modelAndView;
        }
    }
    @GetMapping(value = "/edit-employee/{id}", produces = "application/json;charset=UTF-8")
    public ModelAndView showEditForm(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        if(employee != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee", employee);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-employee")
    public ModelAndView updateNote(@Validated @ModelAttribute("employee") Employee employee,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            return modelAndView;
        } else {
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("message", "employee updated successfully");
            return modelAndView;
        }
    }

//    @GetMapping("/delete-employee/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id){
//        Employee employee = employeeService.findById(id);
//        if(employee != null) {
//            ModelAndView modelAndView = new ModelAndView("/employee/delete");
//            modelAndView.addObject("employee", employee);
//            return modelAndView;
//
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete-employee")
//    public String deleteNote(@ModelAttribute("employee") Employee employee){
//        employeeService.remove(employee.getId());
//        return "redirect:/list";
//    }
    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.remove(id);
        return "redirect:/list";
    }
    @GetMapping(value = "/view-employee/{id}", produces = "application/json;charset=UTF-8" )
    public  ModelAndView viewEmployee(@PathVariable Long id){
        Employee employee = employeeService.findById(id);
        if(employee != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/view");
            modelAndView.addObject("employee", employee);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

}
