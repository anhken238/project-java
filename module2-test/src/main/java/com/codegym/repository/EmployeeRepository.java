package com.codegym.repository;

import com.codegym.model.EmployeeGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<com.codegym.model.Employee, Long> {
    Iterable<com.codegym.model.Employee> findAllByEmployeeGroup (EmployeeGroup employeeGroup);
    Page<com.codegym.model.Employee> findAllByNameContaining (String name, Pageable pageable);
}
