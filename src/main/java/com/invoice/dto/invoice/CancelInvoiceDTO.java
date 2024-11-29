package com.invoice.dto.invoice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancelInvoiceDTO {
    private String invoiceConfigCode;
    private String sourceSysChannel;
    private String ERADVoucherRefNo;
}
