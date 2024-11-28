package com.invoice.domain;

import lombok.Data;


@Data
public class CustomerDetail {
    private Boolean authenticated;
    private String customerType;
    private String umUserId;
    private String licenseNo;
    private String fullName;
    private int phoneNumber;
    private String email;
    private String emiratesId;
}

