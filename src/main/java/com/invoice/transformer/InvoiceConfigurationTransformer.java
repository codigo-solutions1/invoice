package com.invoice.transformer;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.model.InvoiceConfigurationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceConfigurationTransformer implements Transformer<InvoiceConfigurationModel, InvoiceConfiguration> {


    @Override
    public InvoiceConfiguration toEntity(InvoiceConfigurationModel model) {
        return InvoiceConfiguration.builder()
                .id(model.getId())
                .invoiceConfigurationCode(model.getInvoiceConfigurationCode())
                .serviceCode(model.getServiceCode())
                .entityTypeCode(model.getEntityTypeCode())
                .ledgerAlias(model.getLedgerAlias())
                .invoiceConfirmationUrl(model.getInvoiceConfirmationUrl())
                .callbackUrl(model.getCallbackUrl())
                .build();
    }

    @Override
    public InvoiceConfigurationModel toModel(InvoiceConfiguration entity) {
        return InvoiceConfigurationModel.builder()
                .id(entity.getId())
                .invoiceConfigurationCode(entity.getInvoiceConfigurationCode())
                .serviceCode(entity.getServiceCode())
                .entityTypeCode(entity.getEntityTypeCode())
                .ledgerAlias(entity.getLedgerAlias())
                .invoiceConfirmationUrl(entity.getInvoiceConfirmationUrl())
                .callbackUrl(entity.getCallbackUrl())
                .build();
    }

}