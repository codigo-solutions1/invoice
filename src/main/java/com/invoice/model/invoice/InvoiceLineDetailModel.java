package com.invoice.model.invoice;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class InvoiceLineDetailModel {
    @NotNull(message = "Fee is required")
    private BigDecimal fee;
    private int quantity;
}
