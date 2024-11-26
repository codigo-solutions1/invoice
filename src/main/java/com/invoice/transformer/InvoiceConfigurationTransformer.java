package com.invoice.transformer;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.model.InvoiceConfigurationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceConfigurationTransformer implements Transformer<InvoiceConfigurationModel, InvoiceConfiguration> {

    private final InvoiceTypeTransformer invoiceTypeTransformer;

    @Override
    public InvoiceConfiguration toEntity(InvoiceConfigurationModel model) {

        return InvoiceConfiguration.builder()
                .id(model.getId())
                .invoiceConfigurationCode(model.getInvoiceConfigurationCode())
                .invoiceConfirmationUrl(model.getInvoiceConfirmationUrl())
                .callbackUrl(model.getCallbackUrl())
                .dmAcquisitionApiKey(model.getDmAcquisitionApiKey())
                .pgConfirmationGatewayKey(model.getPgConfirmationGatewayKey())
                .sourceChannel(model.getSourceChannel())
                .invoiceTypes(invoiceTypeTransformer.toEntities(model.getInvoiceType()))
                .build();
    }

    @Override
    public InvoiceConfigurationModel toModel(InvoiceConfiguration entity) {
        return InvoiceConfigurationModel.builder()
                .id(entity.getId())
                .invoiceConfigurationCode(entity.getInvoiceConfigurationCode())
                .invoiceConfirmationUrl(entity.getInvoiceConfirmationUrl())
                .callbackUrl(entity.getCallbackUrl())
                .dmAcquisitionApiKey(entity.getDmAcquisitionApiKey())
                .pgConfirmationGatewayKey(entity.getPgConfirmationGatewayKey())
                .sourceChannel(entity.getSourceChannel())
                .invoiceType(invoiceTypeTransformer.toModels(entity.getInvoiceTypes()))
                .build();
    }
}
