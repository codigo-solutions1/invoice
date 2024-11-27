package com.invoice.handler;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.domain.InvoiceDomain;
import com.invoice.model.InvoiceModel;
import com.invoice.service.InvoiceService;
import com.invoice.transformer.InvoiceTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceHandler {

    private final InvoiceTransformer invoiceTransformer;
    private final InvoiceService invoiceService;

    public InvoiceModel createInvoice(InvoiceModel invoiceModel) {
        InvoiceDomain invoiceDomain = invoiceTransformer.toEntity(invoiceModel);
        InvoiceDomain savedInvoice = invoiceService.create(invoiceDomain);
        return invoiceTransformer.toModel(savedInvoice);
    }
}
