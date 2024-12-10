package com.invoice.service;
import com.invoice.domain.invoice.Invoice;

import java.util.UUID;

public interface InvoiceService {
    Invoice createInvoice(Invoice invoice);

    Invoice cancelInvoice(UUID id, String cancelRemarks);
}
