package com.invoice.service;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.domain.invoice.Invoice;
import com.invoice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceConfigurationService invoiceConfigurationService;

    @Override
    public Invoice createInvoice(Invoice invoice) {
        //TODO: find configuration by invoiceConfigurationType and configuration code
        InvoiceConfiguration configuration = invoiceConfigurationService.findByConfigurationCode(invoice.getConfigurationCode());
        Invoice invoiceFromDB = invoiceRepository.save(invoice);
        invoiceFromDB.setInvoiceConfiguration(configuration);
        return invoiceFromDB;
    }

}

