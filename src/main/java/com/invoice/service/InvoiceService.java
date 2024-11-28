package com.invoice.service;

import com.invoice.dto.invoice.InvoiceDTO;
import com.invoice.domain.Invoice;

public interface InvoiceService {
    Invoice saveInvoice(InvoiceDTO dto);
}
