package com.codegym.service.impl;

import com.codegym.model.EmployeeGroup;
import com.codegym.repository.EmployeeGroupRepository;
import com.codegym.service.EmployeeGroupService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeGroupServiceImpl implements EmployeeGroupService {
    @Autowired
    private EmployeeGroupRepository employeeGroupRepository;

    @Override
    public Iterable<EmployeeGroup> findAll() {
        return employeeGroupRepository.findAll();
    }

    @Override
    public EmployeeGroup findById(Long id) {
        return employeeGroupRepository.findOne(id);
    }

    @Override
    public void save(EmployeeGroup employeeGroup) {
        employeeGroupRepository.save(employeeGroup);
    }

    @Override
    public void remove(Long id) {
        employeeGroupRepository.delete(id);
    }
}
