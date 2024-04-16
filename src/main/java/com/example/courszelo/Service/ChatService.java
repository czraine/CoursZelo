package com.example.courszelo.Service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.ResourceAccessException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatService {

    private static final Logger log = LoggerFactory.getLogger(ChatService.class);
    private final RestTemplate restTemplate;
    private final String flaskApiUrl = "http://localhost:5000/predict";

    public ChatService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getChatbotResponse(String message) {
        try {
            Map<String, String> request = new HashMap<>();
            request.put("message", message);
            return restTemplate.postForObject(flaskApiUrl, request, String.class);
        } catch (ResourceAccessException e) {
            log.error("Connection problem with Flask API", e);
            return "Error: Unable to connect to the chatbot service.";
        } catch (Exception e) {
            log.error("An unexpected error occurred", e);
            return "Error: An unexpected error occurred.";
        }
    }
}
