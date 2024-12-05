package com.invoice.transformer;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.dto.InvoiceConfigurationDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceConfigurationTransformer implements Transformer<InvoiceConfigurationDTO, InvoiceConfiguration> {

    private final InvoiceConfigurationTypeTransformer invoiceConfigurationTypeTransformer;

    @Override
    public InvoiceConfiguration toEntity(InvoiceConfigurationDTO model) {
        return InvoiceConfiguration.builder()
                .id(model.getId())
                .invoiceConfigurationCode(model.getInvoiceConfigurationCode())
                .invoiceConfigurationType(invoiceConfigurationTypeTransformer.toEntity(model.getInvoiceConfigurationType()))
                .createdDate(model.getCreatedDate())
                .modifiedDate(model.getModifiedDate())
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
                .createdDate(entity.getCreatedDate())
                .modifiedDate(entity.getModifiedDate())
                .sourceSystemCode(entity.getSourceSystemCode())
                .paymentConfirmationUrl(entity.getPaymentConfirmationUrl())
                .serviceProviderCode(entity.getServiceProviderCode())
                .callbackUrl(entity.getCallbackUrl())
                .sourceSysChannel(entity.getSourceSysChannel())
                .build();
    }
}
