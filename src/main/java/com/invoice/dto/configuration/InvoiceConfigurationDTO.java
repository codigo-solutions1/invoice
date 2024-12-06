package com.invoice.dto.configuration;

import com.invoice.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class InvoiceConfigurationDTO extends ResponseDTO {
    private UUID id;
    private String invoiceConfigurationCode;
    private InvoiceConfigurationTypeDTO invoiceConfigurationType;
    private String sourceSystemCode;
    private String paymentConfirmationUrl;
    private String serviceProviderCode;
    private String callbackUrl;
    private String sourceSysChannel;

    public UUID getId(){
    return id == null? UUID.randomUUID() : id;
    }
}

