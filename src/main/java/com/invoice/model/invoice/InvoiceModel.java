package com.invoice.model.invoice;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceModel {
    private UUID id;
    @NotNull(message = "Source system app reference number is required")
    private String sourceSystemAppRefNo;
    @NotNull(message = "Source system voucher number is required")
    private String sourceSysVoucherNo;
    @NotNull(message = "Source system app reference date is required")
    private String sourceSysAppRefDate;
    @NotNull(message = "Source system config code is required")
    private String invoiceConfigCode;
    @NotNull(message = "Description is required")
    private String description;
    private String language;
    private CustomerDetailModel customerDetail;
    private InvoiceLineDetailModel invoiceLineDetail;
    private ReserveAttributeModel reserveAttribute;

}
