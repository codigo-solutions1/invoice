package com.invoice.dto.invoice;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class InvoiceLineDetailResponseDTO {
    private BigDecimal fee;
    private int quantity;
    private String sourceSystemCode;
    private String paymentConfirmationUrl;
    private String serviceProviderCode;
}
