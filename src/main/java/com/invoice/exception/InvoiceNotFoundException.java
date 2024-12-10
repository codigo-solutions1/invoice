package com.invoice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceNotFoundException extends RuntimeException {

    private final static String MESSAGE = "Invoice not found";

    public InvoiceNotFoundException() {
        super(MESSAGE);
    }
}
