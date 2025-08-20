package com.example.javaapr2025springcontroller.repository;

import com.example.javaapr2025springcontroller.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository //
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
