package com.invoice.transformer;

import static org.junit.jupiter.api.Assertions.*;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.model.InvoiceConfigurationModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class InvoiceConfigurationTransformerTest {

    private InvoiceConfigurationTransformer transformer;

    @BeforeEach
    public void setup() {
        transformer = new InvoiceConfigurationTransformer();
    }

    @Test
    public void testToEntity() {
        InvoiceConfigurationModel model = InvoiceConfigurationModel.builder()
                .id(UUID.randomUUID())
                .invoiceConfigurationCode("INV-123")
                .serviceCode("SRV-001")
                .entityTypeCode("ETC-001")
                .ledgerAlias("LED-001")
                .invoiceConfirmationUrl("https://confirmation.url")
                .callbackUrl("https://callback.url")
                .build();

        InvoiceConfiguration entity = transformer.toEntity(model);

        assertNotNull(entity, "Entity should not be null");
        assertEquals(model.getId(), entity.getId(), "ID should match");
        assertEquals(model.getInvoiceConfigurationCode(), entity.getInvoiceConfigurationCode(), "Code should match");
        assertEquals(model.getServiceCode(), entity.getServiceCode(), "Service Code should match");
        assertEquals(model.getEntityTypeCode(), entity.getEntityTypeCode(), "Entity Type Code should match");
        assertEquals(model.getLedgerAlias(), entity.getLedgerAlias(), "Ledger Alias should match");
        assertEquals(model.getInvoiceConfirmationUrl(), entity.getInvoiceConfirmationUrl(), "Invoice Confirmation URL should match");
        assertEquals(model.getCallbackUrl(), entity.getCallbackUrl(), "Callback URL should match");
    }

    @Test
    public void testToModel() {
        InvoiceConfiguration entity = InvoiceConfiguration.builder()
                .id(UUID.randomUUID())
                .invoiceConfigurationCode("INV-123")
                .serviceCode("SRV-001")
                .entityTypeCode("ETC-001")
                .ledgerAlias("LED-001")
                .invoiceConfirmationUrl("https://confirmation.url")
                .callbackUrl("https://callback.url")
                .build();

        InvoiceConfigurationModel model = transformer.toModel(entity);

        assertNotNull(model, "Model should not be null");
        assertEquals(entity.getId(), model.getId(), "ID should match");
        assertEquals(entity.getInvoiceConfigurationCode(), model.getInvoiceConfigurationCode(), "Code should match");
        assertEquals(entity.getServiceCode(), model.getServiceCode(), "Service Code should match");
        assertEquals(entity.getEntityTypeCode(), model.getEntityTypeCode(), "Entity Type Code should match");
        assertEquals(entity.getLedgerAlias(), model.getLedgerAlias(), "Ledger Alias should match");
        assertEquals(entity.getInvoiceConfirmationUrl(), model.getInvoiceConfirmationUrl(), "Invoice Confirmation URL should match");
        assertEquals(entity.getCallbackUrl(), model.getCallbackUrl(), "Callback URL should match");
    }
}