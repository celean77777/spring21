package com.celean.spring21.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppException {

    private String message;
    private List<String> stack;
    public AppException(String message) {
        this.message = message;
    }

    public AppException(Exception e) {
        message = e.getMessage();
        stack = Arrays.stream(e.getStackTrace())
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}