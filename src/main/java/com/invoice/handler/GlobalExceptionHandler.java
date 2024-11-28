package com.invoice.handler;

import com.invoice.exception.DuplicateEntryException;
import com.invoice.model.ErrorResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
//@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(DuplicateEntryException.class)
//    public ResponseEntity<ErrorResponseModel> handleNullPointerException(DuplicateEntryException ex) {
//        log.error("Duplicate entry issue: ", ex);
//        ErrorResponseModel ErrorResponseModel = new ErrorResponseModel(HttpStatus.CONFLICT.getReasonPhrase(), ex.getMessage());
//        return new ResponseEntity<>(ErrorResponseModel, HttpStatus.CONFLICT);
//    }
}
