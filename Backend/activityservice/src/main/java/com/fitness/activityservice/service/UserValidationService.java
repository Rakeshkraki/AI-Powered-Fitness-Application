package com.fitness.activityservice.service;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class UserValidationService {

    private final WebClient userServiceWebClient;


    public UserValidationService(WebClient userServiceWebClient) {
        this.userServiceWebClient = userServiceWebClient;
    }

    public boolean validateUser(String userId) {
        try {
            return Boolean.TRUE.equals(userServiceWebClient.get()
                    .uri("/users/{userID}/valid", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block());
        } catch (WebClientResponseException e) {
           if (e.getStatusCode() == HttpStatus.NOT_FOUND) throw new RuntimeException("user not found : " + userId);
           else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) throw new RuntimeException("Invalid User Id : " + userId);
        }
        return false;
    }
}
