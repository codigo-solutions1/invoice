package com.invoice.domain;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Table(name = "vouchers")
public class InvoiceDomain {
    @Id
    private final UUID id;
    private final String sourceSystemAppRefNo;
    private final String sourceSysVoucherNo;
    private final LocalDateTime sourceSysAppRefDate;
    private final String paymentConfigCode;
    private final String voucherConfigType;
    private final String fullName;
    private final String phoneNumber;
    private final String email;
    private final String customerType;
    private final String licenseNumber;
    private final String userId;
    private final double fees;
    private final int quantity;
    private final String language;



}
