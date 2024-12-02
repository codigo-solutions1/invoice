package com.invoice.transformer;

import com.invoice.domain.invoice.InvoiceLineDetail;
import com.invoice.dto.invoice.InvoiceLineDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceLineDetailTransformer implements Transformer<InvoiceLineDetailDTO, InvoiceLineDetail> {

    @Override
    public InvoiceLineDetail toEntity(InvoiceLineDetailDTO model) {
        return model == null ? null : InvoiceLineDetail.builder()
                .id(model.getId())
                .productCode(model.getProductCode())
                .quantity(model.getQuantity())
                .price(model.getPrice())
                .build();
    }

    @Override
    public InvoiceLineDetailDTO toModel(InvoiceLineDetail entity) {
        return entity == null ? null : InvoiceLineDetailDTO.builder()
                .id(entity.getId())
                .productCode(entity.getProductCode())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .build();
    }
}
