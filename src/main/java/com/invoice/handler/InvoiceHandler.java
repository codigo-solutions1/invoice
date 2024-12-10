package com.invoice.handler;

import com.invoice.adapter.InvoiceAdapter;
import com.invoice.domain.InvoiceConfiguration;
import com.invoice.domain.invoice.Invoice;
import com.invoice.dto.*;
import com.invoice.dto.invoice.InvoiceDTO;
import com.invoice.dto.invoice.InvoiceLineDetailResponseDTO;
import com.invoice.dto.invoice.inquire.InquireInvoiceCriteriaDTO;
import com.invoice.dto.invoice.inquire.InquireInvoiceResponseDTO;
import com.invoice.dto.invoice.outstanding.OutstandingInvoiceDTO;
import com.invoice.dto.invoice.outstanding.OutstandingInvoiceResponseDTO;
import com.invoice.expert.LegacyInvoiceExpert;
import com.invoice.service.InvoiceConfigurationService;
import com.invoice.service.InvoiceService;
import com.invoice.transformer.CustomerDetailTransformer;
import com.invoice.transformer.InvoiceTransformer;
import com.invoice.transformer.ReserveAttributeTransformer;
import com.invoice.validator.InvoiceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceHandler {

    private final InvoiceConfigurationService invoiceConfigurationService;
    private final InvoiceValidator invoiceValidator;
    private final InvoiceTransformer invoiceTransformer;
    private final InvoiceService invoiceService;
    private final LegacyInvoiceExpert legacyInvoiceExpert;
    private final CustomerDetailTransformer customerDetailTransformer;
    private final ReserveAttributeTransformer reserveAttributeTransformer;
    private final InvoiceAdapter invoiceAdapter;

    public InvoiceResponseDTO createInvoice(InvoiceDTO model) {
        invoiceValidator.validate(model);
        Invoice invoice = invoiceTransformer.toEntity(model);
        Invoice invoiceFromDB = invoiceService.createInvoice(invoice);
//        legacyInvoiceExpert.create(invoiceFromDB);
        return createResponse(invoiceFromDB, model.getInvoiceConfigurationCode());
    }

    public ResponseDTO cancelInvoice(CancelInvoiceCriteriaDTO request) {
        InvoiceConfiguration invoiceConfiguration = invoiceConfigurationService.findByConfigurationCode(request.getInvoiceConfigurationCode());
//        legacyInvoiceExpert.cancel(request, invoiceConfiguration);
        return ResponseDTO.builder()
                .responseCode("200")
                .description("Data saved successfully")
                .build();
    }

    private InvoiceResponseDTO createResponse(Invoice invoiceFromDB, String invoiceConfigCode) {
        InvoiceConfiguration configuration = invoiceConfigurationService.findByConfigurationCode(invoiceConfigCode);
        return createInvoiceResponse(invoiceFromDB, configuration);
    }

    public InquireInvoiceResponseDTO inquireInvoice(InquireInvoiceCriteriaDTO request) {
        InvoiceConfiguration invoiceConfiguration = invoiceConfigurationService.findByConfigurationCode(request.getInvoiceConfigurationCode());
        legacyInvoiceExpert.inquire(request.getInvoiceConfigurationCode(), request.getSourceSysChannel(), request.getERADVoucherRefNo());
        return InquireInvoiceResponseDTO.builder()
                .responseCode("200")
                .description("Data saved successfully")
                .build();
    }

    public OutstandingInvoiceResponseDTO getInvoicesByCriteria(String userId, OutstandingInvoiceDTO request) {
        return invoiceAdapter.getInvoicesByCriteria(userId, request);
    }


    private InvoiceResponseDTO createInvoiceResponse(Invoice invoiceFromDB, InvoiceConfiguration configuration) {
        return InvoiceResponseDTO.builder()
                .responseCode(String.valueOf(HttpStatus.CREATED.value()))
                .description("Data saved successfully")
                .sourceSystemAppRefNo(invoiceFromDB.getSourceSystemAppRefNo())
                .sourceSysVoucherNo(invoiceFromDB.getSourceSysVoucherNo())
                .sourceSysAppRefDate(invoiceFromDB.getSourceSysAppRefDate())
                .language(invoiceFromDB.getLanguage())
                .sourceSysChannel(invoiceFromDB.getSourceSysChannel())
                .customerDetail(customerDetailTransformer.toModel(invoiceFromDB.getCustomerDetail()))
                .invoiceLineDetail(invoiceFromDB.getInvoiceLineDetail().stream()
                        .map(line -> {
                            return InvoiceLineDetailResponseDTO.builder()
                                    .fee(line.getFee())
                                    .quantity(line.getQuantity())
                                    .sourceSystemCode(configuration.getSourceSystemCode())
                                    .paymentConfirmationUrl(configuration.getPaymentConfirmationUrl())
                                    .serviceProviderCode(configuration.getServiceProviderCode())
                                    .build();
                        }).toList()
                )
                .reserveAttribute(reserveAttributeTransformer.toModel(invoiceFromDB.getReserveAttribute()))
                .build();
    }
}
