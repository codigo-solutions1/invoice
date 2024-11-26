package com.invoice.service;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.exception.DuplicateEntryException;
import com.invoice.repository.InvoiceConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InvoiceConfigurationServiceImpl implements InvoiceConfigurationService{

    private final InvoiceConfigurationRepository invoiceConfigurationRepository;

    @Override
    public InvoiceConfiguration create(InvoiceConfiguration configuration) {
        if (invoiceConfigurationRepository.existsByInvoiceConfigurationCode(configuration.getInvoiceConfigurationCode()))
            throw new DuplicateEntryException("Duplicate entry for invoice configuration code: " + configuration.getInvoiceConfigurationCode());
        return invoiceConfigurationRepository.save(configuration);
    }
}

