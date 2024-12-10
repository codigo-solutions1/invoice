package com.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancelInvoiceCriteriaDTO {
    private UUID id;
    private String invoiceConfigurationCode;
    private String sourceSysChannel;
    private String ERADVoucherRefNo;
    private String cancelRemarks;
}
