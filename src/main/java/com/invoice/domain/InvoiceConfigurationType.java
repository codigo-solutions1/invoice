package com.invoice.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InvoiceConfigurationType {
    private final  String type;
    private final String serviceCode;
    private final String entityTypeCode;
    private final String ledgerAlias;
}
