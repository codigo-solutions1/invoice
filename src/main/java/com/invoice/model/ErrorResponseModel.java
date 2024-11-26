package com.invoice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponseModel {
    private String errorCode;
    private String message;
}