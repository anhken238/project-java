package com.codegym.service;

import com.codegym.model.EmployeeGroup;

public interface EmployeeGroupService {
    Iterable<EmployeeGroup> findAll();
    EmployeeGroup   findById(Long id);
    void save(EmployeeGroup category);
    void remove(Long id);
}
