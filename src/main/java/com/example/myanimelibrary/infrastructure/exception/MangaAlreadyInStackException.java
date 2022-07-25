package com.example.myanimelibrary.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MangaAlreadyInStackException extends RuntimeException {

    public MangaAlreadyInStackException(String message) {
        super(message);
    }
}
