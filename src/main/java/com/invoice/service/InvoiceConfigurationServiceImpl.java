package com.invoice.service;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.repository.InvoiceConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InvoiceConfigurationServiceImpl implements InvoiceConfigurationService{

    private final InvoiceConfigurationRepository invoiceConfigurationRepository;

    @Override
    public InvoiceConfiguration create(InvoiceConfiguration configuration) {
        return invoiceConfigurationRepository.save(configuration);
    }
}

