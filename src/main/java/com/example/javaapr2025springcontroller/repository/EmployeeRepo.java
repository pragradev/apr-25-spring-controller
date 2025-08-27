package com.example.javaapr2025springcontroller.repository;

import com.example.javaapr2025springcontroller.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM EMP e where e.FIRST_NAME= ?1") // sql - native query
    List<Employee> getByFNwithSQL(String firstName);
    @Query(value = "SELECT e FROM Employee e where e.firstName= ?1") // jpql
    List<Employee> getByFN(String firstName, String lastName);

    List<Employee> findAllByFirstName(String firstName); // jpa
    // List<Map<String,Object>>

}
