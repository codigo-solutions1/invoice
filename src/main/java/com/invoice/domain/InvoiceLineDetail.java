package com.invoice.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InvoiceLineDetail {
    private BigDecimal fee;
    private int quantity;
}

