package com.invoice.handler;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.domain.invoice.Invoice;
import com.invoice.dto.InvoiceCriteriaDTO;
import com.invoice.dto.InvoiceResponseDTO;
import com.invoice.dto.ResponseDTO;
import com.invoice.dto.invoice.InvoiceDTO;
import com.invoice.expert.InvoiceExpert;
import com.invoice.transformer.InvoiceTransformer;
import com.invoice.validator.InvoiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceHandler {

    private final InvoiceValidator invoiceValidator;
    private final InvoiceTransformer invoiceTransformer;
    private final Invoice invoice;
    private final InvoiceService invoiceService;

    public InvoiceResponseDTO createInvoice(InvoiceDTO model) {
        invoiceValidator.validate(model);
        //invoiceExpert.create(invoiceDTO);
        Invoice invoice = invoiceTransformer.toEntity(model);
        InvoiceConfiguration configurationFromDB = invoiceService.createInvoice(invoice);
        return invoiceTransformer.toModel(configurationFromDB);
        //return InvoiceResponseDTO.builder()
                //.responseCode("200")
                //.description("Data saved successfully")
                //.UPRSInvoiceNo("")
                //.build();
    }

    public ResponseDTO cancelInvoice(String invoiceConfigCode, InvoiceCriteriaDTO invoiceCriteriaDTO){
        invoiceExpert.cancel(invoiceConfigCode, invoiceCriteriaDTO);
        return ResponseDTO.builder()
                .responseCode("200")
                .description("Data saved successfully")
                .build();
    }

}
