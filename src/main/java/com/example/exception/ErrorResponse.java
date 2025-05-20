package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
    private long timestamp;
    
    // Constructor, getters, setters
}
