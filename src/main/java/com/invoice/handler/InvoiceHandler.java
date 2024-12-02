package com.invoice.handler;

import com.invoice.dto.InvoiceCriteriaDTO;
import com.invoice.dto.InvoiceResponseDTO;
import com.invoice.dto.ResponseDTO;
import com.invoice.dto.invoice.InvoiceDTO;
import com.invoice.expert.InvoiceExpert;
import com.invoice.validator.InvoiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceHandler {

    private final InvoiceValidator invoiceValidator;
    private final InvoiceExpert invoiceExpert;

    public InvoiceResponseDTO createInvoice(InvoiceDTO invoiceDTO) {
        invoiceValidator.validate(invoiceDTO);
        invoiceExpert.create(invoiceDTO);
        return InvoiceResponseDTO.builder()
                .responseCode("200")
                .description("Data saved successfully")
                .UPRSInvoiceNo("")
                .build();
    }

    public ResponseDTO cancelInvoice(String invoiceConfigCode, InvoiceCriteriaDTO invoiceCriteriaDTO){
        invoiceExpert.cancel(invoiceConfigCode, invoiceCriteriaDTO);
        return ResponseDTO.builder()
                .responseCode("200")
                .description("Data saved successfully")
                .build();
    }

}
