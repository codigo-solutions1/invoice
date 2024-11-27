package com.invoice.transformer;

import static org.junit.jupiter.api.Assertions.*;

import com.invoice.domain.InvoiceType;
import com.invoice.model.InvoiceTypeModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class InvoiceTypeTransformerTest {

    private InvoiceTypeTransformer transformer;

    @BeforeEach
    public void setup(){
        transformer = new InvoiceTypeTransformer();
    }

    @Test
    public void testToEntity() {
        InvoiceTypeModel model = InvoiceTypeModel.builder()
                .id(UUID.randomUUID())
                .entityTypeCode("CODE123")
                .ledgerAlias("ALIAS")
                .type("INVOICE")
                .serviceCode("SERVICE123")
                .build();

        InvoiceType entity = transformer.toEntity(model);

        assertNotNull(entity);
        assertEquals(model.getId(), entity.getId());
        assertEquals(model.getEntityTypeCode(), entity.getEntityTypeCode());
        assertEquals(model.getLedgerAlias(), entity.getLedgerAlias());
        assertEquals(model.getType(), entity.getType());
        assertEquals(model.getServiceCode(), entity.getServiceCode());
    }

    @Test
    public void testToModel() {
        InvoiceType entity = InvoiceType.builder()
                .id(UUID.randomUUID())
                .entityTypeCode("CODE123")
                .ledgerAlias("ALIAS")
                .type("INVOICE")
                .serviceCode("SERVICE123")
                .build();

        InvoiceTypeModel model = transformer.toModel(entity);

        assertNotNull(model);
        assertEquals(entity.getId(), model.getId());
        assertEquals(entity.getEntityTypeCode(), model.getEntityTypeCode());
        assertEquals(entity.getLedgerAlias(), model.getLedgerAlias());
        assertEquals(entity.getType(), model.getType());
        assertEquals(entity.getServiceCode(), model.getServiceCode());
    }
}
