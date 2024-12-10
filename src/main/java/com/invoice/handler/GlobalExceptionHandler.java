package com.invoice.handler;

import com.invoice.dto.ErrorResponseDTO;
import com.invoice.exception.DuplicateEntryException;
import com.invoice.exception.InvoiceNotFoundException;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@Hidden
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<ErrorResponseDTO> handleDuplicateEntryException(DuplicateEntryException ex) {
        log.error("Duplicate entry issue: ", ex);
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(String.valueOf(HttpStatus.BAD_REQUEST.value()), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvoiceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvoiceNotFoundException(InvoiceNotFoundException ex) {
        log.error("Invoice not found issue: ", ex);
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(String.valueOf(HttpStatus.BAD_REQUEST.value()), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.error("Field validation issue: ", ex);
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
