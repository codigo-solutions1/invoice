package com.invoice.transformer;

import static org.junit.jupiter.api.Assertions.*;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.domain.InvoiceType;
import com.invoice.model.InvoiceConfigurationModel;
import com.invoice.model.InvoiceTypeModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

public class InvoiceConfigurationTransformerTest {

    private InvoiceConfigurationTransformer transformer;

    @BeforeEach
    public void setup() {
        InvoiceTypeTransformer invoiceTypeTransformer = new InvoiceTypeTransformer();
        transformer = new InvoiceConfigurationTransformer(invoiceTypeTransformer);
    }

    @Test
    public void testToEntity() {
        InvoiceConfigurationModel model = InvoiceConfigurationModel.builder()
                .id(UUID.randomUUID())
                .invoiceConfigurationCode("INV-123")
                .invoiceConfirmationUrl("https://confirmation.url")
                .callbackUrl("https://callback.url")
                .dmAcquisitionApiKey("apiKey")
                .pgConfirmationGatewayKey("gatewayKey")
                .sourceChannel("WEB")
                .invoiceType(List.of(
                        createInvoiceTypeModel("Code1"),
                        createInvoiceTypeModel("Code2")
                ))
                .build();

        InvoiceConfiguration entity = transformer.toEntity(model);

        assertNotNull(entity);
        assertEquals(model.getId(), entity.getId());
        assertEquals(model.getInvoiceConfigurationCode(), entity.getInvoiceConfigurationCode());
        assertEquals(model.getInvoiceConfirmationUrl(), entity.getInvoiceConfirmationUrl());
        assertEquals(model.getCallbackUrl(), entity.getCallbackUrl());
        assertEquals(model.getDmAcquisitionApiKey(), entity.getDmAcquisitionApiKey());
        assertEquals(model.getPgConfirmationGatewayKey(), entity.getPgConfirmationGatewayKey());
        assertEquals(model.getSourceChannel(), entity.getSourceChannel());
        assertNotNull(entity.getInvoiceTypes());
        assertEquals(2, entity.getInvoiceTypes().size());
    }

    @Test
    public void testToModel() {
        InvoiceConfiguration entity = InvoiceConfiguration.builder()
                .id(UUID.randomUUID())
                .invoiceConfigurationCode("INV-123")
                .invoiceConfirmationUrl("https://confirmation.url")
                .callbackUrl("https://callback.url")
                .dmAcquisitionApiKey("apiKey")
                .pgConfirmationGatewayKey("gatewayKey")
                .sourceChannel("WEB")
                .invoiceTypes(List.of(
                        createInvoiceType("Code1"),
                        createInvoiceType("Code2")
                ))
                .build();

        InvoiceConfigurationModel model = transformer.toModel(entity);

        assertNotNull(model);
        assertEquals(entity.getId(), model.getId());
        assertEquals(entity.getInvoiceConfigurationCode(), model.getInvoiceConfigurationCode());
        assertEquals(entity.getInvoiceConfirmationUrl(), model.getInvoiceConfirmationUrl());
        assertEquals(entity.getCallbackUrl(), model.getCallbackUrl());
        assertEquals(entity.getDmAcquisitionApiKey(), model.getDmAcquisitionApiKey());
        assertEquals(entity.getPgConfirmationGatewayKey(), model.getPgConfirmationGatewayKey());
        assertEquals(entity.getSourceChannel(), model.getSourceChannel());
        assertNotNull(model.getInvoiceType());
        assertEquals(2, model.getInvoiceType().size());
    }

    private InvoiceType createInvoiceType(String entryTypeCode) {
        return InvoiceType.builder()
                .id(UUID.randomUUID())
                .entityTypeCode(entryTypeCode)
                .ledgerAlias("ALIAS1")
                .type("TYPE1")
                .serviceCode("SERVICE1")
                .build();
    }

    private InvoiceTypeModel createInvoiceTypeModel(String entityTypeCode) {
        return InvoiceTypeModel.builder()
                .id(UUID.randomUUID())
                .entityTypeCode(entityTypeCode)
                .ledgerAlias("ALIAS1")
                .type("TYPE1")
                .serviceCode("SERVICE1")
                .build();
    }
}
