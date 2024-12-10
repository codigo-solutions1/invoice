package com.invoice.dto;

import com.invoice.dto.invoice.CustomerDetailDTO;
import com.invoice.dto.invoice.InvoiceLineDetailResponseDTO;
import com.invoice.dto.invoice.ReserveAttributeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceResponseDTO extends ResponseDTO {
    private String sourceSystemAppRefNo;
    private String sourceSysVoucherNo;
    private String sourceSysAppRefDate;
    private String eradVoucherRefNo;
    private String description;
    private String language;
    private String sourceSysChannel;
    private CustomerDetailDTO customerDetail;
    private List<InvoiceLineDetailResponseDTO> invoiceLineDetail;
    private ReserveAttributeDTO reserveAttribute;
}
