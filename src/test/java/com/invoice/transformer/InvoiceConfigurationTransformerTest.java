package com.invoice.transformer;

import static org.junit.jupiter.api.Assertions.*;

import com.invoice.domain.InvoiceConfiguration;
import com.invoice.domain.InvoiceConfigurationType;
import com.invoice.dto.configuration.InvoiceConfigurationDTO;
import com.invoice.dto.configuration.InvoiceConfigurationTypeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

public class InvoiceConfigurationTransformerTest {

    private InvoiceConfigurationTransformer transformer;
    private InvoiceConfigurationTypeTransformer invoiceConfigurationTypeTransformer;

    @BeforeEach
    public void setup() {
        invoiceConfigurationTypeTransformer = new InvoiceConfigurationTypeTransformer();
        transformer = new InvoiceConfigurationTransformer(invoiceConfigurationTypeTransformer);
    }

    @Test
    public void testToEntity() {
        InvoiceConfigurationTypeDTO typeDTO = InvoiceConfigurationTypeDTO.builder()
                .type("Standard")
                .serviceCode("SRV-001")
                .entityTypeCode("ETC-001")
                .ledgerAlias("LED-001")
                .build();

        InvoiceConfigurationDTO model = InvoiceConfigurationDTO.builder()
                .id(UUID.randomUUID())
                .invoiceConfigurationCode("INV-123")
                .invoiceConfigurationType(typeDTO)
                .createdDate(Instant.now())
                .modifiedDate(Instant.now())
                .sourceSystemCode("SYS-001")
                .paymentConfirmationUrl("https://payment.url")
                .serviceProviderCode("SP-001")
                .callbackUrl("https://callback.url")
                .sourceSysChannel("Channel-1")
                .build();

        InvoiceConfiguration entity = transformer.toEntity(model);

        assertNotNull(entity, "Entity should not be null");
        assertEquals(model.getId(), entity.getId(), "ID should match");
        assertEquals(model.getInvoiceConfigurationCode(), entity.getInvoiceConfigurationCode(), "Invoice Configuration Code should match");
        assertEquals(model.getCreatedDate(), entity.getCreatedDate(), "Created Date should match");
        assertEquals(model.getModifiedDate(), entity.getModifiedDate(), "Modified Date should match");
        assertEquals(model.getSourceSystemCode(), entity.getSourceSystemCode(), "Source System Code should match");
        assertEquals(model.getPaymentConfirmationUrl(), entity.getPaymentConfirmationUrl(), "Payment Confirmation URL should match");
        assertEquals(model.getServiceProviderCode(), entity.getServiceProviderCode(), "Service Provider Code should match");
        assertEquals(model.getCallbackUrl(), entity.getCallbackUrl(), "Callback URL should match");
        assertEquals(model.getSourceSysChannel(), entity.getSourceSysChannel(), "Source System Channel should match");

        // Nested Type Assertions
        assertNotNull(entity.getInvoiceConfigurationType(), "Invoice Configuration Type should not be null");
        assertEquals(typeDTO.getType(), entity.getInvoiceConfigurationType().getType(), "Type should match");
        assertEquals(typeDTO.getServiceCode(), entity.getInvoiceConfigurationType().getServiceCode(), "Service Code should match");
        assertEquals(typeDTO.getEntityTypeCode(), entity.getInvoiceConfigurationType().getEntityTypeCode(), "Entity Type Code should match");
        assertEquals(typeDTO.getLedgerAlias(), entity.getInvoiceConfigurationType().getLedgerAlias(), "Ledger Alias should match");
    }

    @Test
    public void testToModel() {
        InvoiceConfigurationType type = InvoiceConfigurationType.builder()
                .type("Standard")
                .serviceCode("SRV-001")
                .entityTypeCode("ETC-001")
                .ledgerAlias("LED-001")
                .build();

        InvoiceConfiguration entity = InvoiceConfiguration.builder()
                .id(UUID.randomUUID())
                .invoiceConfigurationCode("INV-123")
                .invoiceConfigurationType(type)
                .createdDate(Instant.now())
                .modifiedDate(Instant.now())
                .sourceSystemCode("SYS-001")
                .paymentConfirmationUrl("https://payment.url")
                .serviceProviderCode("SP-001")
                .callbackUrl("https://callback.url")
                .sourceSysChannel("Channel-1")
                .build();

        InvoiceConfigurationDTO model = transformer.toModel(entity);

        assertNotNull(model, "Model should not be null");
        assertEquals(entity.getId(), model.getId(), "ID should match");
        assertEquals(entity.getInvoiceConfigurationCode(), model.getInvoiceConfigurationCode(), "Invoice Configuration Code should match");
        assertEquals(entity.getCreatedDate(), model.getCreatedDate(), "Created Date should match");
        assertEquals(entity.getModifiedDate(), model.getModifiedDate(), "Modified Date should match");
        assertEquals(entity.getSourceSystemCode(), model.getSourceSystemCode(), "Source System Code should match");
        assertEquals(entity.getPaymentConfirmationUrl(), model.getPaymentConfirmationUrl(), "Payment Confirmation URL should match");
        assertEquals(entity.getServiceProviderCode(), model.getServiceProviderCode(), "Service Provider Code should match");
        assertEquals(entity.getCallbackUrl(), model.getCallbackUrl(), "Callback URL should match");
        assertEquals(entity.getSourceSysChannel(), model.getSourceSysChannel(), "Source System Channel should match");

        // Nested Type Assertions
        assertNotNull(model.getInvoiceConfigurationType(), "Invoice Configuration Type should not be null");
        assertEquals(type.getType(), model.getInvoiceConfigurationType().getType(), "Type should match");
        assertEquals(type.getServiceCode(), model.getInvoiceConfigurationType().getServiceCode(), "Service Code should match");
        assertEquals(type.getEntityTypeCode(), model.getInvoiceConfigurationType().getEntityTypeCode(), "Entity Type Code should match");
        assertEquals(type.getLedgerAlias(), model.getInvoiceConfigurationType().getLedgerAlias(), "Ledger Alias should match");
    }
}
