package com.invoice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "vouchers")
public class InvoiceDomain {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false, unique = true, columnDefinition = "RAW(16)")
    private UUID id;

    private String sourceSystemAppRefNo;
    private String sourceSysVoucherNo;
    private LocalDateTime sourceSysAppRefDate;
    private String paymentConfigCode;
    private String voucherConfigType;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String customerType;
    private String licenseNumber;
    private String userId;
    private double fees;
    private int quantity;
    private String language;
}
