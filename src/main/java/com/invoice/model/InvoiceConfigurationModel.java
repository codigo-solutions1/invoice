package com.invoice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceConfigurationModel {
    private UUID id;
    private String invoiceConfigurationCode;
    private String serviceCode;
    private String entityTypeCode;
    private String ledgerAlias;
    private String invoiceConfirmationUrl;
    private String callbackUrl;

    public UUID getId(){
    return id == null? UUID.randomUUID() : id;
    }
}

