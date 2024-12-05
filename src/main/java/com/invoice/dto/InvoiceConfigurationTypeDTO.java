package com.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceConfigurationTypeDTO {

    private String type;
    private String serviceCode;
    private String entityTypeCode;
    private String ledgerAlias;
}
