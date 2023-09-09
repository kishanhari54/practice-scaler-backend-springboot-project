package com.harshet.products.exceptions;

import com.harshet.products.dto.NotFoundExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<NotFoundExceptionDTO> handleNotFoundException(NotFoundException exception){
        NotFoundExceptionDTO response = new NotFoundExceptionDTO(HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
