package com.invoice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceTypeModel {

    private UUID id;

    private String type;

    private String serviceCode;

    private String entityTypeCode;

    private String ledgerAlias;

    private String msgSourceCode;
}
