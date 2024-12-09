package com.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PendingInvoiceDTO {
    private String invoiceNumber;
    private String description;
    private BigDecimal invoiceAmount;
    private BigDecimal pendingAmount;
    private String invoiceDate;
    private String sourceSysRefNumber;
    private String serviceName;
}
