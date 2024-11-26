package com.invoice.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Builder
public class InvoiceType {

    @Id
    private final UUID id;
    private final String type;
    private final String serviceCode;
    private final String entityTypeCode;
    private final String ledgerAlias;
}
