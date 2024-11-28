package com.invoice.service;

import com.invoice.domain.InvoiceDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{


    @Override
    public InvoiceDomain create(InvoiceDomain invoiceDomain) {
        return null;
    }
}
