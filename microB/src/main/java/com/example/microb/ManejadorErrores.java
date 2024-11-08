package com.example.microb;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorErrores {

    @ExceptionHandler(OrlandoException.class)
    protected ResponseEntity<RespuestaDto> handleErroresDeOrlando() {
        return new ResponseEntity<>(new RespuestaDto("No se puede procesar", "002"),
                HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
