package com.invoice.service;

import com.invoice.domain.InvoiceConfiguration;

public interface InvoiceConfigurationService {
    InvoiceConfiguration create(InvoiceConfiguration configuration);

    InvoiceConfiguration findByConfigurationCode(String invoiceConfigurationCode);
}
