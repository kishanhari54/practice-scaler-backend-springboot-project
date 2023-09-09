package com.harshet.products.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class NotFoundExceptionDTO {
    private HttpStatus status;
    private String message;
}
