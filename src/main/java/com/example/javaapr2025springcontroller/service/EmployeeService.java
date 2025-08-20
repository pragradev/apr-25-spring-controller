package com.example.javaapr2025springcontroller.service;

import com.example.javaapr2025springcontroller.entity.Employee;
import com.example.javaapr2025springcontroller.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLDataException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public Employee addEmp(Employee employee){
        return employeeRepo.save(employee);
    }


    public List<Employee> getAllEmp(){
        List<Employee> all = null;
        try {
            all = employeeRepo.findAll();
        } catch (DataAccessException e){

        }
        return all;
    }
}
