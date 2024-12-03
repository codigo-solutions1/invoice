package com.invoice.handler;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.domain.invoice.Invoice;
import com.invoice.dto.InvoiceCriteriaDTO;
import com.invoice.dto.ResponseDTO;
import com.invoice.dto.invoice.InvoiceDTO;
import com.invoice.expert.LegacyInvoiceExpert;
import com.invoice.service.InvoiceConfigurationService;
import com.invoice.transformer.InvoiceTransformer;
import com.invoice.validator.InvoiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.invoice.service.InvoiceService;

@Component
@RequiredArgsConstructor
public class InvoiceHandler {

    private final InvoiceConfigurationService invoiceConfigurationService;
    private final InvoiceValidator invoiceValidator;
    private final InvoiceTransformer invoiceTransformer;
    private final InvoiceService invoiceService;
    private final LegacyInvoiceExpert legacyInvoiceExpert;

    public InvoiceDTO createInvoice(InvoiceDTO model) {
        invoiceValidator.validate(model);
        Invoice invoice = invoiceTransformer.toEntity(model);
        Invoice invoiceFromDB = invoiceService.createInvoice(invoice);
        legacyInvoiceExpert.create(invoiceFromDB);
        return invoiceTransformer.toModel(invoiceFromDB);
    }

    public ResponseDTO cancelInvoice(String invoiceConfigCode, InvoiceCriteriaDTO invoiceCriteriaDTO){
        InvoiceConfiguration invoiceConfiguration = invoiceConfigurationService.findByConfigurationCode(invoiceConfigCode);

//        invoiceExpert.cancel(invoiceConfigCode, invoiceCriteriaDTO);
        return ResponseDTO.builder()
                .responseCode("200")
                .description("Data saved successfully")
                .build();
    }

}
