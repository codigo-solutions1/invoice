package com.invoice.dto.invoice.outstanding;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutstandingInvoiceResponseDTO {

    private List<OutstandingInvoiceDTO> invoices;
}
