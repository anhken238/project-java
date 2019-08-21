package com.codegym.service;

import com.codegym.model.Employee;
import com.codegym.model.EmployeeGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);


    Employee findById(Long id);

    void save(Employee employee);

    void remove(Long id);

    Iterable<com.codegym.model.Employee> findAllByEmployeeGroup (EmployeeGroup employeeGroup);
    Page<com.codegym.model.Employee> findAllByNameContaining (String name, Pageable pageable);
}
