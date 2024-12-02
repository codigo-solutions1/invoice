package com.invoice.domain.invoice;

import com.invoice.dto.invoice.CustomerDetailDTO;
import com.invoice.dto.invoice.InvoiceLineDetailDTO;
import com.invoice.dto.invoice.ReserveAttributeDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@Document(collection = "invoice")
public class Invoice {
    @Id
    private UUID Id;
    @NotNull(message = "Source system app reference number is required")
    private String sourceSystemAppRefNo;
    @NotNull(message = "Source system voucher number is required")
    private String sourceSysVoucherNo;
    @NotNull(message = "Source system app reference date is required")
    private String sourceSysAppRefDate;
    @NotNull(message = "Source system configuration code is required")
    private String invoiceConfigurationCode;
    @NotNull(message = "Description is required")
    private String description;
    private String language;
    private String sourceSysChannel;
    private CustomerDetail customerDetail;
    private List<InvoiceLineDetail> invoiceLineDetail;
    private ReserveAttribute reserveAttribute;
}
