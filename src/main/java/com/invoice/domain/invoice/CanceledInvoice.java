package com.invoice.domain.invoice;

import lombok.experimental.SuperBuilder;

@SuperBuilder
class CanceledInvoice extends Invoice {
    @Override
    public Invoice submit() {
        return null;
    }

    @Override
    public Invoice cancel() {
        throw new IllegalStateException("Canceled invoice cannot be canceled again");
    }

    @Override
    public InvoiceStatus getStatus() {
        return InvoiceStatus.CANCELED;
    }
}
