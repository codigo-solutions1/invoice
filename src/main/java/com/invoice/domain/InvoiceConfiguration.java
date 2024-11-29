package com.invoice.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@Document(collection = "invoiceConfiguration")
public class InvoiceConfiguration {
    @Id
    private final UUID id;
    @NotEmpty
    private final String invoiceConfigurationCode;
    @NotEmpty
    private final String serviceCode;
    @NotEmpty
    private final String sourceSystemCode;
    @NotEmpty
    private final String entityTypeCode;
    @NotEmpty
    private final String ledgerAlias;
    @NotEmpty
    private final String invoiceConfirmationUrl;
    private final String serviceProviderCode;
    private final String callbackUrl;


}

