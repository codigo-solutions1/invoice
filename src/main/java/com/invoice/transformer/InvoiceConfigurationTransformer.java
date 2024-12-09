package com.invoice.transformer;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.dto.configuration.InvoiceConfigurationDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class InvoiceConfigurationTransformer implements Transformer<InvoiceConfigurationDTO, InvoiceConfiguration> {

    private final InvoiceConfigurationTypeTransformer invoiceConfigurationTypeTransformer;

    @Override
    public InvoiceConfiguration toEntity(InvoiceConfigurationDTO model) {
        LocalDate now = LocalDate.now();

        boolean isNew = model.getId() == null;

        return InvoiceConfiguration.builder()
                .id(model.getId())
                .invoiceConfigurationCode(model.getInvoiceConfigurationCode())
                .invoiceConfigurationType(invoiceConfigurationTypeTransformer.toEntity(model.getInvoiceConfigurationType()))
                .createdDate(now)
                .modifiedDate(isNew ? now : model.getCreatedDate())
                .sourceSystemCode(model.getSourceSystemCode())
                .paymentConfirmationUrl(model.getPaymentConfirmationUrl())
                .serviceProviderCode(model.getServiceProviderCode())
                .callbackUrl(model.getCallbackUrl())
                .sourceSysChannel(model.getSourceSysChannel())
                .build();
    }

    @Override
    public InvoiceConfigurationDTO toModel(InvoiceConfiguration entity) {
        return InvoiceConfigurationDTO.builder()
                .id(entity.getId())
                .invoiceConfigurationCode(entity.getInvoiceConfigurationCode())
                .invoiceConfigurationType(invoiceConfigurationTypeTransformer.toModel(entity.getInvoiceConfigurationType()))
                .createdDate(entity.getCreatedDate()) // Include createdDate in the response
                .modifiedDate(entity.getModifiedDate()) // Include modifiedDate in the response
                .sourceSystemCode(entity.getSourceSystemCode())
                .paymentConfirmationUrl(entity.getPaymentConfirmationUrl())
                .serviceProviderCode(entity.getServiceProviderCode())
                .callbackUrl(entity.getCallbackUrl())
                .sourceSysChannel(entity.getSourceSysChannel())
                .build();
    }
}
