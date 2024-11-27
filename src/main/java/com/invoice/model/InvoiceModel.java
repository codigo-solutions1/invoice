package com.invoice.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceModel {
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false, unique = true, columnDefinition = "RAW(16)")
    private UUID id;
    private String sourceSystemAppRefNo;
    private String sourceSysVoucherNo;
    private String sourceSysAppRefDate;
    private String paymentConfigCode;
    private String voucherConfigType;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String customerType;
    private Double fees;
    private Integer quantity;
    private String language;
}
