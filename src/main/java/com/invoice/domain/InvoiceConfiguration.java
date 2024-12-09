package com.invoice.domain;


import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
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
    private final String sourceSystemCode;
    private final String paymentConfirmationUrl;
    private final String serviceProviderCode;
    private final String callbackUrl;
    private final String sourceSysChannel;
    @CreatedDate
    private Instant createdDate;
    @LastModifiedDate
    private Instant modifiedDate;
}

