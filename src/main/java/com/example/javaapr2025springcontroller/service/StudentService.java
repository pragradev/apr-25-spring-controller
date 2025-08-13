package com.example.javaapr2025springcontroller.service;

import com.example.javaapr2025springcontroller.dto.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentService {
    List<Student> studentList = new ArrayList<>();

    public List<Student> addStudents(Student student, String action){
        if("new".equals(action)){
            studentList = new ArrayList<>();
        }
        studentList.add(student);
        return studentList;
    }
}
