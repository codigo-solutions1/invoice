package com.invoice.service;

import com.invoice.domain.InvoiceDomain;
import com.invoice.model.InvoiceModel;
import com.invoice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{

    private final InvoiceRepository invoiceRepository;

    @Override
    public InvoiceDomain create(InvoiceDomain invoiceDomain) {
        return invoiceRepository.save(invoiceDomain);
    }
}
