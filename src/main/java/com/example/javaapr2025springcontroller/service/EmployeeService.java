package com.example.javaapr2025springcontroller.service;

import com.example.javaapr2025springcontroller.entity.Employee;
import com.example.javaapr2025springcontroller.entity.EmployeeMachine;
import com.example.javaapr2025springcontroller.entity.EmployeeReviews;
import com.example.javaapr2025springcontroller.repository.EmployeeMachineRepo;
import com.example.javaapr2025springcontroller.repository.EmployeeRepo;
import com.example.javaapr2025springcontroller.repository.EmployeeReviewRepo;
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
    @Autowired
    EmployeeMachineRepo employeeMachineRepo;
    @Autowired
    EmployeeReviewRepo employeeReviewRepo;

    public Employee addEmp(Employee employee){
        return employeeRepo.save(employee);

//        List<EmployeeReviews> employeeReviews = employeeReviewRepo.saveAll(employee.getEmployeeReviews());
//        employee.setEmployeeReviews(employeeReviews);
//        EmployeeMachine savedEmployeeMachine = employeeMachineRepo.save(employee.getEmployeeMachine());
//        employee.setEmployeeMachine(savedEmployeeMachine);
//        return employeeRepo.save(employee);
    }
    // session
    // transaction
    // all 5 operation
    // rollback
    // no issues: commit transaction and flush session



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

    public List<Employee> getEmpByFirstName(String firstName){
        return employeeRepo.getByFNwithSQL(firstName);
    }

    public boolean deleteEmployee(Integer id){
        try {
            employeeRepo.deleteById(id);
            return true;
        } catch (DataAccessException e){
            e.printStackTrace();
            return false;
        }

    }


}
