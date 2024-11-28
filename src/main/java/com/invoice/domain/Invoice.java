package com.invoice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Data
public class Invoice {
    @Id
    private UUID id;
    private String sourceSystemAppRefNo;
    private String sourceSysVoucherNo;
    private String sourceSysAppRefDate;
    private String invoiceConfigCode;
    private String description;
    private String language;
    private String customerDetail;

    private List<String> invoiceLineDetail;

    private String reserveAttribute;
}

