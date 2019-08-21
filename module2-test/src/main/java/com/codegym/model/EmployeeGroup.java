package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "employeegroup")
public class EmployeeGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String nameEmployeeGroup;

    public EmployeeGroup() {
    }

    public EmployeeGroup(@NotEmpty @Size(min = 3, max = 100) String nameEmployeeGroup) {
        this.nameEmployeeGroup = nameEmployeeGroup;
    }

    @OneToMany(mappedBy = "employeeGroup",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<com.codegym.model.Employee> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEmployeeGroup() {
        return nameEmployeeGroup;
    }

    public void setNameEmployeeGroup(String nameEmployeeGroup) {
        this.nameEmployeeGroup = nameEmployeeGroup;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
