package com.invoice.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceModel {
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
    private String licenseNumber;
    private String userId;
    private Double fees;
    private Integer quantity;
    private String language;
    public UUID getId(){
        return id == null? UUID.randomUUID() : id;
    }


}
