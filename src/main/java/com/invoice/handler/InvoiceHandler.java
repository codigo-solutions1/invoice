package com.invoice.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.invoice.dto.ResponseDTO;
import com.invoice.dto.InvoiceCriteriaDTO;
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

    public ResponseDTO createInvoice(InvoiceDTO invoiceDTO) {
        invoiceValidator.validate(invoiceDTO);
        invoiceExpert.create(invoiceDTO);
        return new ResponseDTO();
    }

    public ResponseDTO cancelInvoice(String invoiceConfigCode, InvoiceCriteriaDTO invoiceCriteriaDTO){
        invoiceExpert.cancel(invoiceConfigCode, invoiceCriteriaDTO);
        return new ResponseDTO();
    }

}
