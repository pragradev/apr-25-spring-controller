package com.example.javaapr2025springcontroller.httpClients;

import com.example.javaapr2025springcontroller.dto.GitUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "gitClient", url = "https://api.github.com")
public interface GitUserClient {

    @GetMapping("/users/{username}")
    GitUser getUserByUsername(@PathVariable("username") String username);
}
