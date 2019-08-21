package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 5, max = 60)
    private String code;

    @NotEmpty
    @Size(min = 5, max = 60)
    private String name;

    @NotEmpty
    private String  dateOfBirth;

    @NotEmpty
    @Pattern(regexp = "([0-9]{9,12})",message = "only enter numbers and range from 9 to 12")
    private String identityCard;

    @Size(min = 6, max = 50)
    private String address;

    private String  gender;

    @NotEmpty
    @Pattern(regexp = "(09|08|03)+([0-9]{8,12})", message = "Only entered numbers and between 7 and 12, the beginning of the number 03,08,09")
    private String phone;


    @NotEmpty
    @Email(message="Email does not format")
    private String email;

    @ManyToOne
    @JoinColumn(name = "employeegroup_id")
    private EmployeeGroup employeeGroup;

    public Employee() {
    }

    public Employee(@NotEmpty @Size(min = 5, max = 60) String code, @NotEmpty @Size(min = 5, max = 60) String name, @NotEmpty String dateOfBirth, @NotEmpty @Pattern(regexp = "([0-9]{9,12})", message = "only enter numbers and range from 9 to 12") String identityCard, @Size(min = 6, max = 50) String address, String gender, @NotEmpty @Pattern(regexp = "(09|08|03)+([0-9]{8,12})", message = "Only entered numbers and between 7 and 12, the beginning of the number 03,08,09") String phone, @NotEmpty @Email(message = "Email does not format") String email) {
        this.code = code;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.identityCard = identityCard;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeGroup getEmployeeGroup() {
        return employeeGroup;
    }

    public void setEmployeeGroup(EmployeeGroup employeeGroup) {
        this.employeeGroup = employeeGroup;
    }
}
