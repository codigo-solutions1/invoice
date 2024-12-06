package com.invoice.handler;

import com.invoice.dto.configuration.InvoiceConfigurationDTO;
import com.invoice.domain.InvoiceConfiguration;
import com.invoice.dto.configuration.InvoiceConfigurationResponseDTO;
import com.invoice.service.InvoiceConfigurationService;
import com.invoice.transformer.InvoiceConfigurationTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InvoiceConfigurationHandler {

    private final InvoiceConfigurationTransformer invoiceConfigurationTransformer;
    private final InvoiceConfigurationService invoiceConfigurationService;

    public InvoiceConfigurationResponseDTO createInvoiceConfiguration(InvoiceConfigurationDTO model) {
        InvoiceConfiguration configuration = invoiceConfigurationTransformer.toEntity(model);
        InvoiceConfiguration configurationFromDB = invoiceConfigurationService.create(configuration);

        return InvoiceConfigurationResponseDTO.builder()
                .responseCode(String.valueOf(HttpStatus.CREATED.value()))
                .description("Invoice configuration created successfully")
                .invoiceConfigurationCode(configurationFromDB.getInvoiceConfigurationCode())
                .id(configurationFromDB.getId())
                .build();
    }
}