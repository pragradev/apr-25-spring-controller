package com.example.javaapr2025springcontroller.controller;

import com.example.javaapr2025springcontroller.dto.GitUser;
import com.example.javaapr2025springcontroller.service.GitUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("git")
public class GitUserController {
    private final GitUserService gitUserService;

    public GitUserController(GitUserService gitUserService) {
        this.gitUserService = gitUserService;
    }

    @GetMapping("user/{username}")
    public GitUser fetchUser(@PathVariable("username") String username){
        return gitUserService.getUser(username);
    }
}
