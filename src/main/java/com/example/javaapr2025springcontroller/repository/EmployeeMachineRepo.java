package com.example.javaapr2025springcontroller.repository;

import com.example.javaapr2025springcontroller.entity.EmployeeMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMachineRepo extends JpaRepository<EmployeeMachine, Long> {
}
