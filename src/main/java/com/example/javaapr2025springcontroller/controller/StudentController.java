package com.example.javaapr2025springcontroller.controller;

import com.example.javaapr2025springcontroller.dto.Student;
import com.example.javaapr2025springcontroller.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    // http
    // Get, Post, Put, Delete, Patch, Head,..
    @Autowired
    StudentService studentService;

    @GetMapping("/hello/{lastName}")
    public String hello(@RequestParam("key") String name,@PathVariable("lastName") String lastName){
        return "Hello World " + name + " " + lastName + "!";
    }


    @DeleteMapping("/add/{action}")
    public List<Student> addStudent(@RequestBody Student student,@PathVariable("action") String action){
        System.out.println(student);
        return studentService.addStudents(student, action);
    }


}
