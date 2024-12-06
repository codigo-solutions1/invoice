package com.invoice.transformer;

import com.invoice.domain.InvoiceConfigurationType;
import com.invoice.dto.configuration.InvoiceConfigurationTypeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceConfigurationTypeTransformer implements Transformer<InvoiceConfigurationTypeDTO, InvoiceConfigurationType> {

    @Override
    public InvoiceConfigurationType toEntity(InvoiceConfigurationTypeDTO model) {
        return InvoiceConfigurationType.builder()
                .type(model.getType())
                .serviceCode(model.getServiceCode())
                .entityTypeCode(model.getEntityTypeCode())
                .ledgerAlias(model.getLedgerAlias())
                .build();
    }

    @Override
    public InvoiceConfigurationTypeDTO toModel(InvoiceConfigurationType entity) {
        return InvoiceConfigurationTypeDTO.builder()
                .type(entity.getType())
                .serviceCode(entity.getServiceCode())
                .entityTypeCode(entity.getEntityTypeCode())
                .ledgerAlias(entity.getLedgerAlias())
                .build();
    }
}

