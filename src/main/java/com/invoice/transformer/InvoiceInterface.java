package com.invoice.transformer;


import java.util.List;
import java.util.stream.Collectors;

public interface InvoiceInterface<I, II> {
    II toEntity(I i);

    I toModel(II ii);

    default List<II> toEntities(List<I> models) {
        return models.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<I> toModels(List<II> entities) {
        return entities.stream().map(this::toModel).collect(Collectors.toList());
    }
}
