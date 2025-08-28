package com.example.javaapr2025springcontroller.service;

import com.example.javaapr2025springcontroller.dto.GitUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitUserService {

    private final RestTemplate restTemplate;

    public GitUserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GitUser fetchUser(String username){
        GitUser gitUser = restTemplate.getForObject("https://api.github.com/users/"+username, GitUser.class);
        return gitUser;
    }
}
