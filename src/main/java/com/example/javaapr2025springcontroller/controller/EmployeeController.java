package com.example.javaapr2025springcontroller.controller;

import com.example.javaapr2025springcontroller.entity.Employee;
import com.example.javaapr2025springcontroller.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/add")
    public Employee addEmp(@RequestBody Employee employee){
        return employeeService.addEmp(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmp(){
        return employeeService.getAllEmp();
    }

    @GetMapping("/byId/{id}")
    public Optional<Employee> getById(@PathVariable("id") Integer id){
        return employeeService.getEmpById(id);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @PatchMapping("/patch")
    public Employee patchEmployee(@RequestBody Employee employee){
        return employeeService.patchEmployee(employee);
    }
}
