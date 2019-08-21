package com.codegym.formatter;

import com.codegym.model.EmployeeGroup;
import com.codegym.service.EmployeeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class EmployeeFormatter implements Formatter<EmployeeGroup> {
    private EmployeeGroupService employeeGroupService;
    @Autowired
    public EmployeeFormatter(EmployeeGroupService employeeGroupService) {
        this.employeeGroupService = employeeGroupService;
    }
    @Override
    public EmployeeGroup parse(String text, Locale locale) throws ParseException {
        return employeeGroupService.findById(Long.parseLong(text));
    }

    @Override
    public String print(EmployeeGroup object, Locale locale) {
        return "["+ object.getId() + object.getNameEmployeeGroup()+"]";
    }
}
