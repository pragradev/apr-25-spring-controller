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
import java.util.Objects;
import java.util.Optional;

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

    public Optional<Employee> getEmpById(Integer id){
        return employeeRepo.findById(id);
    }

    public Employee updateEmployee(Employee employee){
        Optional<Employee> optionalEmployee = getEmpById(employee.getEmployeeId());
        if (optionalEmployee.isPresent()){
            employee = employeeRepo.save(employee);
        }
        return employee;
    }

    public Employee patchEmployee(Employee dto){
        Optional<Employee> optionalEmployee = getEmpById(dto.getEmployeeId());
        if (optionalEmployee.isPresent()){
            Employee entity = optionalEmployee.get();
            if (Objects.nonNull(dto.getFirstName())){
                entity.setFirstName(dto.getFirstName());
            }
            if (Objects.nonNull(dto.getLastName())){
                entity.setLastName(dto.getLastName());
            }
            if (Objects.nonNull(dto.getCompany())){
                entity.setCompany(dto.getCompany());
            }
            if (Objects.nonNull(dto.getPhoneNumber())){
                entity.setPhoneNumber(dto.getPhoneNumber());
            }
            return employeeRepo.save(entity);
        }
        return null;
    }
}
