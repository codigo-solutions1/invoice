package com.invoice.domain.invoice;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class InvoiceLineDetail {
    @NotNull(message = "Fee is required")
    private BigDecimal fee;
    private int quantity;
}
