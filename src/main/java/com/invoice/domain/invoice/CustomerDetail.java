package com.invoice.domain.invoice;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerDetail {
    @NotNull(message = "Authenticated is required")
    private Boolean authenticated;

    private String customerType;
    private String umUserId;
    private String licenseNo;

    private String fullName;
    private String phoneNumber;
    private String email;
    private String emiratesId;
}
