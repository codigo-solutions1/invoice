package com.invoice.handler;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.domain.invoice.Invoice;
import com.invoice.dto.CancelInvoiceCriteriaDTO;
import com.invoice.dto.InvoiceResponseDTO;
import com.invoice.dto.ResponseDTO;
import com.invoice.dto.invoice.InvoiceDTO;
import com.invoice.expert.LegacyInvoiceExpert;
import com.invoice.service.InvoiceConfigurationService;
import com.invoice.transformer.InvoiceConfigurationTransformer;
import com.invoice.transformer.InvoiceTransformer;
import com.invoice.validator.InvoiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.invoice.service.InvoiceService;

@Component
@RequiredArgsConstructor
public class InvoiceHandler {

    private final InvoiceConfigurationService invoiceConfigurationService;
    private final InvoiceValidator invoiceValidator;
    private final InvoiceTransformer invoiceTransformer;
    private final InvoiceConfigurationTransformer invoiceConfigurationTransformer;
    private final InvoiceService invoiceService;
    private final LegacyInvoiceExpert legacyInvoiceExpert;

    public InvoiceResponseDTO createInvoice(InvoiceDTO model) {
        invoiceValidator.validate(model);
        Invoice invoice = invoiceTransformer.toEntity(model);
        Invoice invoiceFromDB = invoiceService.createInvoice(invoice);
        legacyInvoiceExpert.create(invoiceFromDB);
        return createResponse(invoiceFromDB);
    }

    private InvoiceResponseDTO createResponse(Invoice invoiceFromDB) {
        return InvoiceResponseDTO.builder()
                .responseCode(String.valueOf(HttpStatus.CREATED.value()))
                .invoice(invoiceTransformer.toModel(invoiceFromDB))
                .invoiceConfiguration(invoiceConfigurationTransformer.toModel(invoiceFromDB.getInvoiceConfiguration()))
                .description("Data saved successfully")
                .build();
    }

    public ResponseDTO cancelInvoice(String invoiceConfigCode, CancelInvoiceCriteriaDTO cancelInvoiceCriteriaDTO){
        InvoiceConfiguration invoiceConfiguration = invoiceConfigurationService.findByConfigurationCode(invoiceConfigCode);

//        invoiceExpert.cancel(invoiceConfigCode, invoiceCriteriaDTO);
        return ResponseDTO.builder()
                .responseCode("200")
                .description("Data saved successfully")
                .build();
    }

}
