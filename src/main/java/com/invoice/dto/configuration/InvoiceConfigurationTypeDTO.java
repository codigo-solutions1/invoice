package com.invoice.dto.configuration;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceConfigurationTypeDTO {

    @NotEmpty(message = "Invoice configuration type cannot be empty")
    private String invoiceConfigurationType;
    @NotEmpty(message = "Service code cannot be empty")
    private String serviceCode;
    @NotEmpty(message = "Entity type code cannot be empty")
    private String entityTypeCode;
    @NotEmpty(message = "Ledger alias cannot be empty")
    private String ledgerAlias;
}
