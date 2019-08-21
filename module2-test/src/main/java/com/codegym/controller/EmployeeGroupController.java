package com.codegym.controller;

import com.codegym.model.EmployeeGroup;
import com.codegym.service.EmployeeGroupService;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeGroupController {
    @Autowired
    private EmployeeGroupService employeeGroupService;
    @Autowired
    private EmployeeService employeeService;
    //show list
    @GetMapping(value = "/employeegroup", produces = "application/json;charset=UTF-8")
    public ModelAndView list(){
        Iterable<EmployeeGroup> employeeGroups = employeeGroupService.findAll();
        ModelAndView modelAndView = new ModelAndView("/employeegroup/list");
        modelAndView.addObject("employeegroups", employeeGroups);
        return modelAndView;
    }
    //show form create and create category
    @GetMapping(value = "/create-employeegroup", produces = "application/json;charset=UTF-8")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/employeegroup/create");
        modelAndView.addObject("employeegroup", new EmployeeGroup());
        return modelAndView;
    }
    @PostMapping("/create-employeegroup")
    public ModelAndView save(@Validated @ModelAttribute("employeegroup") EmployeeGroup employeeGroup, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/employeegroup/create");
            return modelAndView;
        } else {
            employeeGroupService.save(employeeGroup);
            ModelAndView modelAndView = new ModelAndView("/employeegroup/create");
            modelAndView.addObject("employeegroup", new EmployeeGroup());
            modelAndView.addObject("message", " create employee of group was success");
            return modelAndView;
        }
    }
    // show form edit and edit
    @GetMapping(value = "/edit-employeegroup/{id}", produces = "application/json;charset=UTF-8")
    public  ModelAndView ShowFormEdit(@PathVariable("id") Long id, EmployeeGroup employeeGroup){
        employeeGroup = employeeGroupService.findById(id);
        if(employeeGroup != null){
            ModelAndView modelAndView = new ModelAndView("/employeegroup/edit");
            modelAndView.addObject("employeegroup", employeeGroup);
            return modelAndView;
        }
        else{
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit-employeegroup")
    public ModelAndView saveEdit(@Validated @ModelAttribute("employeegroup") EmployeeGroup employeeGroup, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("/employeegroup/edit");
            return modelAndView;
        }
        else {
            employeeGroupService.save(employeeGroup);
            ModelAndView modelAndView = new ModelAndView("/employeegroup/edit");
            modelAndView.addObject("employeegroup",employeeGroup);
            modelAndView.addObject("message", "Edit employeegroup was success");
            return modelAndView;
        }
    }
    //delete category
    @GetMapping("/delete-employeegroup/{id}")
    public String groupEmployeeDelete(@PathVariable("id") Long id){
        employeeGroupService.remove(id);
        return "redirect:/employeegroup";
    }

    // show view
    @GetMapping(value = "/view-employeegroup/{id}", produces = "application/json;charset=UTF-8")
    public ModelAndView viewEmployeeGroup(@PathVariable("id") Long id){
        EmployeeGroup employeeGroup = employeeGroupService.findById(id);
        if(employeeGroup == null){
            return new ModelAndView("/error.404");
        }

        Iterable<com.codegym.model.Employee> employees = employeeService.findAllByEmployeeGroup(employeeGroup);

        ModelAndView modelAndView = new ModelAndView("/employeegroup/view");
        modelAndView.addObject("employeegroup", employeeGroup);
        modelAndView.addObject("employee",employees);
        return modelAndView;
    }
}
