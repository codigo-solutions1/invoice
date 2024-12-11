package com.invoice.domain.invoice;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

import java.time.Instant;

@SuperBuilder
@NoArgsConstructor
@TypeAlias("canceledInvoice")
class CanceledInvoice extends Invoice {
    private String reason;
    private Instant canceledAt;
    @Override
    public Invoice submit() {
        throw new IllegalStateException("Canceled invoice cannot be submitted");
    }

    @Override
    public Invoice cancel(String reason) {
        throw new IllegalStateException("Canceled invoice cannot be canceled again");
    }

    @Override
    public InvoiceStatus getStatus() {
        return InvoiceStatus.CANCELED;
    }
}
