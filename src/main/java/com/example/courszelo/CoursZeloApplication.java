package com.example.courszelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CoursZeloApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(CoursZeloApplication.class, args);


    }

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Spécifiez le chemin de votre API
                .allowedOrigins("http://localhost:4200") // Autorisez les requêtes depuis ce domaine
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Autorisez les méthodes HTTP spécifiées
                .allowCredentials(true)// Autorisez l'envoi des cookies
                .allowedHeaders("*");

    }



}
