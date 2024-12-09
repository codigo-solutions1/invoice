package com.invoice.expert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.invoice.adapter.InvoiceAdapter;
import com.invoice.domain.InvoiceConfiguration;
import com.invoice.domain.invoice.Invoice;
import com.invoice.service.InvoiceConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class LegacyInvoiceExpert {

    private final InvoiceConfigurationService invoiceConfigurationService;
    private final InvoiceAdapter invoiceAdapter;

    public void create(Invoice invoice) {
        try {
            InvoiceConfiguration invoiceConfiguration = invoice.getInvoiceConfiguration();
            String jsonInvoice = createInvoiceJson(invoice, invoiceConfiguration);
//            invoiceAdapter.createInvoice(jsonInvoice);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void cancel(String invoiceConfigurationCode, String sourceSysChannel, String eradVoucherRefNo) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
//            String invoiceJson = objectMapper.writeValueAsString();
//            invoiceAdapter.cancelInvoice(invoiceJson);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void inquire(String invoiceConfigurationCode, String sourceSysChannel, String eradVoucherRefNo) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
//            String invoiceJson = objectMapper.writeValueAsString();
//            invoiceAdapter.inquireInvoice(invoiceJson);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private String createInvoiceJson(Invoice invoiceDTO, InvoiceConfiguration invoiceConfiguration) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String invoiceJson = objectMapper.writeValueAsString(invoiceDTO);
        ObjectNode invoiceNode = (ObjectNode) objectMapper.readTree(invoiceJson);
        invoiceNode.put("sourceSystemCode", invoiceConfiguration.getSourceSystemCode());
        invoiceNode.put("serviceProviderCode", invoiceConfiguration.getServiceProviderCode());
        invoiceNode.remove("invoiceConfigurationCode");
        invoiceNode.remove("invoiceConfiguration");
        invoiceNode.get("invoiceLineDetail").forEach(invoiceLineDetail -> {
            ((ObjectNode) invoiceLineDetail).put("ledgerAlias", invoiceConfiguration.getInvoiceConfigurationType().getLedgerAlias());
            ((ObjectNode) invoiceLineDetail).put("serviceCode", invoiceConfiguration.getInvoiceConfigurationType().getServiceCode());
            ((ObjectNode) invoiceLineDetail).put("entityTypeCode", invoiceConfiguration.getInvoiceConfigurationType().getEntityTypeCode());
        });
        return objectMapper.writeValueAsString(invoiceNode);
    }

}
