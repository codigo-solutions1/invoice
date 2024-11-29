package com.invoice.dto.invoice;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class InvoiceLineDetailDTO {
    @NotNull(message = "Fee is required")
    private BigDecimal fee;
    private int quantity;
}