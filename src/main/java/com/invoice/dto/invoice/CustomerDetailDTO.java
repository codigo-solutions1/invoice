package com.invoice.dto.invoice;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CustomerDetailDTO {

    @NotNull(message = "Authenticated is required")
    private Boolean authenticated;

    private String customerType;
    private String umUserId;
    private String licenseNo;

    private String fullName;
    private int phoneNumber;
    private String email;
    private String emiratesId;
}
