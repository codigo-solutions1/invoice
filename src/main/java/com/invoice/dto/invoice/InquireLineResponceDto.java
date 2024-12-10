package com.invoice.dto.invoice;

import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public class InquireLineResponceDto {
    private BigDecimal fee;
    private int quantity;
    private String serviceCode;
    private String entityTypeCode;
    private String ledgerAlias;



}
