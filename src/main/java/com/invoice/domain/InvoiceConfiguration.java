package com.invoice.domain;


import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Getter
@Builder
@Document(collection = "invoiceConfiguration")
public class InvoiceConfiguration {
    @Id
    private final UUID id;
    private final String invoiceConfigurationCode;
    private final InvoiceConfigurationType invoiceConfigurationType;
    private final Instant createdDate;
    private final Instant modifiedDate;
    private final String sourceSystemCode;
    private final String paymentConfirmationUrl;
    private final String serviceProviderCode;
    private final String callbackUrl;
    private final String sourceSysChannel;
}

