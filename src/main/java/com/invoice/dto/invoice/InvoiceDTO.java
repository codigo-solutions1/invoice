package com.invoice.dto.invoice;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceDTO {
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
    private CustomerDetailDTO customerDetail;
    private List<InvoiceLineDetailDTO> invoiceLineDetail;
    private ReserveAttributeDTO reserveAttribute;
}
