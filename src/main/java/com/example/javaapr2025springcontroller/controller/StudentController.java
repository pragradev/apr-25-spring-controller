package com.example.javaapr2025springcontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/student")
public class StudentController {
    // http
    // Get, Post, Put, Delete, Patch, Head,..

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello(){
        return "Hello World!";
    }
    //GET: http://localhost:8080  /student    /hello
}
