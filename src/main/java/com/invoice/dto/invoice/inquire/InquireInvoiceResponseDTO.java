package com.invoice.dto.invoice.inquire;

import com.invoice.dto.ResponseDTO;
import com.invoice.dto.invoice.CustomerDetailDTO;
import com.invoice.dto.invoice.InvoiceLineDetailResponseDTO;
import com.invoice.dto.invoice.ReserveAttributeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InquireInvoiceResponseDTO extends ResponseDTO {

    private String ERADVoucherRefNo;
    private Instant invoiceDate;
    private String currencyCode;
    private double invoiceAmount;
    private double paidAmount;
    private double OutstandingAmount;
    private String invoiceTypeCode;
    private String invoiceTypeName;
    private String paymentStatusCode;
    private String paymentStatusName;
    private String sourceSystemAppRefNo;
    private String sourceSysVoucherNo;
    private String sourceSysAppRefDate;
    private String description;
    private String language;
    private String sourceSysChannel;
    private CustomerDetailDTO customerDetail;
    private List<InvoiceLineDetailResponseDTO> invoiceLineDetail;
    private ReserveAttributeDTO reserveAttribute;
}



