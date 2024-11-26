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

    private List<InvoiceTypeModel> invoiceType;

    private String callbackUrl;

    private String dmAcquisitionApiKey;

    private String invoiceConfirmationUrl;

    private String pgConfirmationGatewayKey;

    private String sourceChannel;

    public UUID getId(){
    return id == null? UUID.randomUUID() : id;
    }
}

