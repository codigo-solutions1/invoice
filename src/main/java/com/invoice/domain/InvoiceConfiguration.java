package com.invoice.domain;

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
    private final String invoiceConfigurationCode;
    private final List<InvoiceType> invoiceTypes;
    private final String callbackUrl;
    private final String dmAcquisitionApiKey;
    private final String invoiceConfirmationUrl;
    private final String pgConfirmationGatewayKey;
    private final String sourceChannel;

}

