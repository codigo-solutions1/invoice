package com.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancelInvoiceCriteriaDTO {
    private String sourceSysChannel;
    private String ERADVoucherRefNo;
}
