package com.example.courszelo.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@AllArgsConstructor
public class FlaskAPIService {
    private final RestTemplate restTemplate;
    private final String flaskApiBaseUrl = "http://localhost:5000";


    public String getCategories() {
        String url = flaskApiBaseUrl + "/categories";
        return this.restTemplate.getForObject(url, String.class);
    }

    public String getQuiz(int category, int amount, String difficulty, String type) {
        String url = UriComponentsBuilder.fromHttpUrl(flaskApiBaseUrl + "/quiz")
                .queryParam("category", category)
                .queryParam("amount", amount)
                .queryParam("difficulty", difficulty)
                .queryParam("type", type)
                .toUriString();

        return this.restTemplate.getForObject(url, String.class);
    }
}
