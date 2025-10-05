package com.activity.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserValidationService {

    private final WebClient userWebClientService;

    public boolean validateUser(Long userId) {
        log.info("Calling user validation API for user Id {} " + userId);
        try {
            return userWebClientService.get()
                    .uri("api/user/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        } catch (WebClientResponseException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                // User not found → return false
                return false;
            } else {
                // For other HTTP errors, rethrow
                throw new RuntimeException("Error calling user validation service: " + e.getStatusCode(), e);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected error", ex);
        }
    }
}
