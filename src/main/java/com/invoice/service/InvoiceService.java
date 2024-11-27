package com.invoice.service;

import com.invoice.domain.InvoiceDomain;
import com.invoice.model.InvoiceModel;

public interface InvoiceService {

    InvoiceDomain create(InvoiceDomain invoiceDomain);
}
