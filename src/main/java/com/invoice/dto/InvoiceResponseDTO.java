package com.invoice.dto;

import com.invoice.dto.invoice.InvoiceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceResponseDTO extends ResponseDTO {
    private InvoiceDTO invoice;
    private InvoiceConfigurationDTO invoiceConfiguration;
}
