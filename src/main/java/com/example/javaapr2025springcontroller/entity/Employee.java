package com.example.javaapr2025springcontroller.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "EMP")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    @Column(name = "FIRST_NAME",length = 50,nullable = false)
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String company;
    @OneToOne()
    private EmployeeMachine employeeMachine;

    @OneToMany(fetch = FetchType.LAZY)
    private List<EmployeeReviews> employeeReviews;



//create table employee (employee_id integer not null, company varchar(255),
// first_name varchar(255), last_name varchar(255), phone_number varchar(255),
// primary key (employee_id))


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(company, employee.company) && Objects.equals(employeeMachine, employee.employeeMachine) && Objects.equals(employeeReviews, employee.employeeReviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, phoneNumber, company, employeeMachine, employeeReviews);
    }

    public EmployeeMachine getEmployeeMachine() {
        return employeeMachine;
    }

    public void setEmployeeMachine(EmployeeMachine employeeMachine) {
        this.employeeMachine = employeeMachine;
    }

    public List<EmployeeReviews> getEmployeeReviews() {
        return employeeReviews;
    }

    public void setEmployeeReviews(List<EmployeeReviews> employeeReviews) {
        this.employeeReviews = employeeReviews;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
