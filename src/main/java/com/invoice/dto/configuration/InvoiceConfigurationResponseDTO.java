package com.invoice.dto.configuration;

import com.invoice.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class InvoiceConfigurationResponseDTO extends ResponseDTO {
    private UUID id;
    private String invoiceConfigurationCode;
}
