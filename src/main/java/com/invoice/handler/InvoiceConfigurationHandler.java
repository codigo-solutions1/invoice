package com.invoice.handler;

import com.invoice.model.InvoiceConfigurationModel;
import com.invoice.domain.InvoiceConfiguration;
import com.invoice.service.InvoiceConfigurationService;
import com.invoice.transformer.InvoiceConfigurationTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InvoiceConfigurationHandler {

    private final InvoiceConfigurationTransformer invoiceConfigurationTransformer;
    private final InvoiceConfigurationService invoiceConfigurationService;

    public InvoiceConfigurationModel createInvoiceConfiguration(InvoiceConfigurationModel model) {
        InvoiceConfiguration configuration = invoiceConfigurationTransformer.toEntity(model);
        InvoiceConfiguration configurationFromDB = invoiceConfigurationService.create(configuration);
        return invoiceConfigurationTransformer.toModel(configurationFromDB);
    }
}

