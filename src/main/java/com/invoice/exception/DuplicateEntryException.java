package com.invoice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DuplicateEntryException extends RuntimeException {

    private String message;
}
