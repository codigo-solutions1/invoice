package com.invoice.domain.invoice;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerDetail {
    @NotNull(message = "Authenticated is required")
    private Boolean authenticated;
    @Size(max = 1)
    private String customerType;
    @Size(max = 50)
    private String umUserId;
    @Size(max = 50)
    private String licenseNo;
    @Size(max = 300)
    private String fullName;
    @Size(max = 50)
    private String phoneNumber;
    @Size(max = 100)
    private String email;
    private String emiratesId;
}
