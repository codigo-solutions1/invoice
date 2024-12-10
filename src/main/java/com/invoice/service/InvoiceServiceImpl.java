package com.invoice.service;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.domain.invoice.Invoice;
import com.invoice.exception.InvoiceNotFoundException;
import com.invoice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


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

    @Override
    public Invoice cancelInvoice(UUID id, String cancelRemarks) {
        Invoice invoice = getInvoice(id);
        invoice.cancel(cancelRemarks);
        return invoiceRepository.save(invoice);
    }

    private Invoice getInvoice(UUID id) {
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
        if(invoiceOptional.isPresent()){
            return invoiceOptional.get();
        }
        else {
            throw new InvoiceNotFoundException();
        }
    }

}

