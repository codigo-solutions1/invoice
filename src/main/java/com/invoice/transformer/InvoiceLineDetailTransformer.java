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
        return InvoiceLineDetail.builder()
                .fee(model.getFee())
                .quantity(model.getQuantity())
                .build();
    }

    @Override
    public InvoiceLineDetailDTO toModel(InvoiceLineDetail entity) {
        InvoiceLineDetailDTO dto = new InvoiceLineDetailDTO();
        dto.setFee(entity.getFee());
        dto.setQuantity(entity.getQuantity());
        return dto;
    }
}
