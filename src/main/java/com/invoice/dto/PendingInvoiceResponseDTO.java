package com.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PendingInvoiceResponseDTO {

    private List<PendingInvoiceDTO> pendingInvoices;
}
