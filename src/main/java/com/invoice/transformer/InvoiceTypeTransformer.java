package com.invoice.transformer;

import com.invoice.domain.InvoiceType;
import com.invoice.model.InvoiceTypeModel;
import org.springframework.stereotype.Component;

@Component
public class InvoiceTypeTransformer implements Transformer<InvoiceTypeModel, InvoiceType>{

    @Override
    public InvoiceType toEntity(InvoiceTypeModel model) {
        return InvoiceType.builder()
                .id(model.getId())
                .entityTypeCode(model.getEntityTypeCode())
                .ledgerAlias(model.getLedgerAlias())
                .type(model.getType())
                .serviceCode(model.getServiceCode())
                .build();
    }

    @Override
    public InvoiceTypeModel toModel(InvoiceType entity) {
        return InvoiceTypeModel.builder()
                .id(entity.getId())
                .entityTypeCode(entity.getEntityTypeCode())
                .ledgerAlias(entity.getLedgerAlias())
                .type(entity.getType())
                .serviceCode(entity.getServiceCode())
                .build();
    }
}
