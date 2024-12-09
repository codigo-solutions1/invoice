package com.invoice.dto.configuration;

import com.invoice.dto.ResponseDTO;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class InvoiceConfigurationDTO extends ResponseDTO {
    private UUID id;
    @NotEmpty(message = "Invoice Configuration Code cannot be empty")
    private String invoiceConfigurationCode;
    private InvoiceConfigurationTypeDTO invoiceConfigurationType;
    @NotEmpty(message = "Source System Code cannot be empty")
    private String sourceSystemCode;
    private String paymentConfirmationUrl;
    @NotEmpty(message = "Service Provider Code cannot be empty")
    private String serviceProviderCode;
    @NotEmpty(message = "Service Provider Name cannot be empty")
    private String sourceSysChannel;
    private String callbackUrl;

    public UUID getId() {
        return id == null ? UUID.randomUUID() : id;
    }
}

