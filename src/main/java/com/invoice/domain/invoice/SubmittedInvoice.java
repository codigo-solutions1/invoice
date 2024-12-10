package com.invoice.domain.invoice;

import lombok.experimental.SuperBuilder;

import java.time.Instant;

@SuperBuilder
public class SubmittedInvoice extends Invoice{
    @Override
    public Invoice submit() {
        throw new IllegalStateException("Submitted invoice cannot be submitted again");
    }

    @Override
    public Invoice cancel(String reason) {
        return CanceledInvoice.builder()
                .id(this.getId())
                .description(this.getDescription())
                .language(this.getLanguage())
                .sourceSysAppRefDate(this.getSourceSysAppRefDate())
                .sourceSysChannel(this.getSourceSysChannel())
                .sourceSysVoucherNo(this.getSourceSysVoucherNo())
                .sourceSystemAppRefNo(this.getSourceSystemAppRefNo())
                .reserveAttribute(this.getReserveAttribute())
                .customerDetail(this.getCustomerDetail())
                .invoiceLineDetail(this.getInvoiceLineDetail())
                .reason(reason)
                .canceledAt(Instant.now())
                .build();
    }

    @Override
    public InvoiceStatus getStatus() {
        return InvoiceStatus.SUBMITTED;
    }
}
