package com.invoice.transformer;

import java.util.List;
import java.util.stream.Collectors;

public interface Transformer<M,E> {

    E toEntity(M m);

    M toModel(E e);


    default List<E> toEntities(List<M> models) {
        return models.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<M> toModels(List<E> entities) {
        return entities.stream().map(this::toModel).collect(Collectors.toList());
    }
}
