package com.invoice.transformer;

import com.invoice.domain.invoice.Invoice;
import com.invoice.domain.invoice.SubmittedInvoice;
import com.invoice.dto.invoice.InvoiceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InvoiceTransformer implements Transformer<InvoiceDTO, Invoice> {

    private final CustomerDetailTransformer customerDetailTransformer;
    private final ReserveAttributeTransformer reserveAttributeTransformer;
    private final InvoiceLineDetailTransformer invoiceLineDetailTransformer;


    @Override
    public Invoice toEntity(InvoiceDTO model) {
        return SubmittedInvoice.builder()
                .id(model.getId())
                .sourceSystemAppRefNo(model.getSourceSystemAppRefNo())
                .sourceSysVoucherNo(model.getSourceSysVoucherNo())
                .sourceSysAppRefDate(model.getSourceSysAppRefDate())
                .description(model.getDescription())
                .language(model.getLanguage())
                .configurationCode(model.getInvoiceConfigurationCode())
                .sourceSysChannel(model.getSourceSysChannel())
                .customerDetail(customerDetailTransformer.toEntity(model.getCustomerDetail()))
                .reserveAttribute(reserveAttributeTransformer.toEntity(model.getReserveAttribute()))
                .invoiceLineDetail(model.getInvoiceLineDetail() != null
                        ? model.getInvoiceLineDetail().stream()
                        .map(invoiceLineDetailTransformer::toEntity)
                        .collect(Collectors.toList())
                        : null)
                .build();
    }

    @Override
    public InvoiceDTO toModel(Invoice entity) {
        return InvoiceDTO.builder()
                .id(entity.getId())
                .sourceSystemAppRefNo(entity.getSourceSystemAppRefNo())
                .sourceSysVoucherNo(entity.getSourceSysVoucherNo())
                .sourceSysAppRefDate(entity.getSourceSysAppRefDate())
                .description(entity.getDescription())
                .language(entity.getLanguage())
                .invoiceConfigurationCode(entity.getConfigurationCode())
                .sourceSysChannel(entity.getSourceSysChannel())
                .customerDetail(customerDetailTransformer.toModel(entity.getCustomerDetail()))
                .reserveAttribute(reserveAttributeTransformer.toModel(entity.getReserveAttribute()))
                .invoiceLineDetail(entity.getInvoiceLineDetail() != null
                        ? entity.getInvoiceLineDetail().stream()
                        .map(invoiceLineDetailTransformer::toModel)
                        .collect(Collectors.toList())
                        : null)
                .build();
    }

}