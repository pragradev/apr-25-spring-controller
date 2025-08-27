package com.example.javaapr2025springcontroller.controller;

import com.example.javaapr2025springcontroller.entity.Employee;
import com.example.javaapr2025springcontroller.entity.EmployeeReviews;
import com.example.javaapr2025springcontroller.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) // json
    public ResponseEntity<Employee> addEmp(@RequestBody Employee employee){
        Employee createdEmployee = employeeService.addEmp(employee);
        ResponseEntity<Employee> employeeResponseEntity = ResponseEntity
                .status(HttpStatusCode.valueOf(201))
                .header("content-type","Application/Json")
                .header("status","1206")
                .body(createdEmployee);
        return employeeResponseEntity;
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

    @GetMapping("/byFirstName")
    public List<Employee> getEmployeesByFirstName(@RequestParam("firstName") String firstName){
        return employeeService.getEmpByFirstName(firstName);
    }

    @GetMapping("/phoneNumber/{id}")
    public String getPhoneNumberOfEmployee(@PathVariable("id") Integer id){
        Employee empById = employeeService.getEmpById(id).get();
        return empById.getPhoneNumber();
    }

    @GetMapping("/reviewDesc/{id}")
    public List<String> getReviewDescOfEmployee(@PathVariable("id") Integer id){
        Employee empById = employeeService.getEmpById(id).get();
        List<EmployeeReviews> employeeReviews = empById.getEmployeeReviews();
        List<String> reviewDesc = employeeReviews.stream().map(er -> er.getReviewDesc()).collect(Collectors.toList());
        return reviewDesc;
    }
}
