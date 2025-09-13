package com.example.javaapr2025springcontroller.service;

import com.example.javaapr2025springcontroller.dto.GitUser;
import com.example.javaapr2025springcontroller.httpClients.GitUserClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class GitUserService {

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    private final GitUserClient gitUserFeignClient;


    public GitUserService(RestTemplate restTemplate, @Qualifier("webClientGitHub") WebClient webClient, GitUserClient gitUserFeignClient) {
        this.restTemplate = restTemplate;
        this.webClient = webClient;
        this.gitUserFeignClient = gitUserFeignClient;
    }

    public GitUser fetchUser(String username){
        GitUser gitUser = restTemplate.getForObject("https://api.github.com/users/"+username, GitUser.class);
        return gitUser;
    }

    public GitUser fetchUserWithWebClient(String username){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return webClient
                .get()
                .uri("/users/"+username)
                .header("userId","John Doe")
                .header("Password","Abc123")
                .retrieve()
                .bodyToMono(GitUser.class)
                //.timeout(Duration.ofMillis(3000)) //300 - 500 millis
                .block();
        // making 3rd api call: must handle exception

    }

    public GitUser getUser(String username){
        return gitUserFeignClient.getUserByUsername(username);
    }
}
