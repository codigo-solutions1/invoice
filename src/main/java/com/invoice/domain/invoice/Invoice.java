package com.invoice.domain.invoice;

import com.invoice.domain.InvoiceConfiguration;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Getter
@SuperBuilder
@Document(collection = "invoice")
public abstract class Invoice {
    @Id
    private UUID id;
    @NotNull(message = "Source system app reference number is required")
    private String sourceSystemAppRefNo;
    @NotNull(message = "Source system voucher number is required")
    private String sourceSysVoucherNo;
    @NotNull(message = "Source system app reference date is required")
    private String sourceSysAppRefDate;
    @NotNull(message = "Description is required")
    private String description;
    private String language;
    private String sourceSysChannel;
    private CustomerDetail customerDetail;
    private List<InvoiceLineDetail> invoiceLineDetail;
    private ReserveAttribute reserveAttribute;
    @Transient
    @Setter
    private String configurationCode;
    @Transient
    @Setter
    private InvoiceConfiguration invoiceConfiguration;


    public abstract Invoice submit();

    public abstract Invoice cancel(String reason);

    public abstract InvoiceStatus getStatus();
}
