package com.example.courszelo.exception;

public class QuizNotFoundException extends RuntimeException {

    public QuizNotFoundException(String message) {
        super(message);
    }
}