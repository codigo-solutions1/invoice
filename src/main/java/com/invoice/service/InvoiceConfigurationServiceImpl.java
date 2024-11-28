package com.invoice.service;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.exception.DuplicateEntryException;
import com.invoice.repository.InvoiceConfigurationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
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

    @Override
    public InvoiceConfiguration findByConfigurationCode(String invoiceConfigurationCode){
        InvoiceConfiguration invoiceConfiguration = invoiceConfigurationRepository.findByInvoiceConfigurationCode(invoiceConfigurationCode);
        if(invoiceConfiguration == null) {
            log.error("Unable to fine invoice configuration by code: "+ invoiceConfigurationCode);
            throw new RuntimeException("Unable to process invoice");
        }
        return invoiceConfiguration;
    }
}

