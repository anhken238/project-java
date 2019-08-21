
package com.codegym.repository;
import com.codegym.model.EmployeeGroup;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeGroupRepository extends PagingAndSortingRepository<EmployeeGroup, Long> {
}
