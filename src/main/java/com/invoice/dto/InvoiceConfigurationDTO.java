package com.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceConfigurationDTO {
    private UUID id;
    private String invoiceConfigurationCode;
    private InvoiceConfigurationTypeDTO invoiceConfigurationTypeDTO;
    private Instant createdDate;
    private Instant modifiedDate;
    private String sourceSystemCode;
    private String paymentConfirmationUrl;
    private String serviceProviderCode;
    private String callbackUrl;
    private String sourceSysChannel;

    public UUID getId(){
    return id == null? UUID.randomUUID() : id;
    }
}

