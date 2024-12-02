package com.invoice.transformer;

import com.invoice.domain.invoice.ReserveAttribute;
import com.invoice.dto.invoice.ReserveAttributeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReserveAttributeTransformer implements Transformer<ReserveAttributeDTO, ReserveAttribute> {

    @Override
    public ReserveAttribute toEntity(ReserveAttributeDTO model) {
        return model == null ? null : ReserveAttribute.builder()
                .attributeKey(model.getAttributeKey())
                .attributeValue(model.getAttributeValue())
                .build();
    }

    @Override
    public ReserveAttributeDTO toModel(ReserveAttribute entity) {
        return entity == null ? null : ReserveAttributeDTO.builder()
                .attributeKey(entity.getAttributeKey())
                .attributeValue(entity.getAttributeValue())
                .build();
    }
}

