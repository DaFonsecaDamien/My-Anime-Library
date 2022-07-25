package com.example.myanimelibrary.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        ApiException apiException = new ApiException(
                resourceNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NameAlreadyTakenException.class)
    public ResponseEntity<Object> handleNameAlreadyTakenException(NameAlreadyTakenException nameAlreadyTakenException) {
        ApiException apiException = new ApiException(
                nameAlreadyTakenException.getMessage(),
                HttpStatus.CONFLICT,
                ZonedDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = AnimeAlreadyInStackException.class)
    public ResponseEntity<Object> handleAnimeAlreadyInStackException(AnimeAlreadyInStackException animeAlreadyInStackException) {
        ApiException apiException = new ApiException(
                animeAlreadyInStackException.getMessage(),
                HttpStatus.CONFLICT,
                ZonedDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = MangaAlreadyInStackException.class)
    public ResponseEntity<Object> handleMangaAlreadyInStackException(MangaAlreadyInStackException mangaAlreadyInStackException) {
        ApiException apiException = new ApiException(
                mangaAlreadyInStackException.getMessage(),
                HttpStatus.CONFLICT,
                ZonedDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.CONFLICT);
    }

    //TODO: add more exception handlers here
}