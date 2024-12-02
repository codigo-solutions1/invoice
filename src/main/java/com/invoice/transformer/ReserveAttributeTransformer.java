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
        return ReserveAttribute.builder()
                .reserve1(model.getReserve1())
                .reserve2(model.getReserve2())
                .reserve3(model.getReserve3())
                .reserve4(model.getReserve4())
                .reserve5(model.getReserve5())
                .reserve6(model.getReserve6())
                .reserve7(model.getReserve7())
                .reserve8(model.getReserve8())
                .reserve9(model.getReserve9())
                .reserve10(model.getReserve10())
                .reserve11(model.getReserve11())
                .reserve12(model.getReserve12())
                .reserve13(model.getReserve13())
                .reserve14(model.getReserve14())
                .reserve15(model.getReserve15())
                .build();
    }

    @Override
    public ReserveAttributeDTO toModel(ReserveAttribute entity) {
        ReserveAttributeDTO dto = new ReserveAttributeDTO();
        dto.setReserve1(entity.getReserve1());
        dto.setReserve2(entity.getReserve2());
        dto.setReserve3(entity.getReserve3());
        dto.setReserve4(entity.getReserve4());
        dto.setReserve5(entity.getReserve5());
        dto.setReserve6(entity.getReserve6());
        dto.setReserve7(entity.getReserve7());
        dto.setReserve8(entity.getReserve8());
        dto.setReserve9(entity.getReserve9());
        dto.setReserve10(entity.getReserve10());
        dto.setReserve11(entity.getReserve11());
        dto.setReserve12(entity.getReserve12());
        dto.setReserve13(entity.getReserve13());
        dto.setReserve14(entity.getReserve14());
        dto.setReserve15(entity.getReserve15());
        return dto;
    }
}
