package com.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PendingInvoiceDTO {
    private String invoiceNumber;
    private String description;
    private double amount;
    private String issueDate;
}
