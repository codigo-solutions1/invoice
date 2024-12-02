package com.invoice.service;
import com.invoice.adapter.InvoiceAdapter;
import com.invoice.domain.invoice.Invoice;
import com.invoice.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



    @Slf4j
    @RequiredArgsConstructor
    @Service
    public class InvoiceServiceImpl implements InvoiceService{
        private final InvoiceRepository invoiceRepository;
        private final InvoiceAdapter invoiceAdapter;

        @Override
        public Invoice createInvoice(Invoice invoice) {
            Invoice savedInvoice = invoiceRepository.save(invoice);
            invoiceAdapter.createInvoice(String.valueOf(savedInvoice));
            return savedInvoice;
        }

    }

