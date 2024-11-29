package com.invoice.expert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.invoice.adapter.InvoiceAdapter;
import com.invoice.domain.InvoiceConfiguration;
import com.invoice.dto.InvoiceCriteriaDTO;
import com.invoice.dto.invoice.InvoiceDTO;
import com.invoice.service.InvoiceConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InvoiceExpert {

    private final InvoiceConfigurationService invoiceConfigurationService;
    private final InvoiceAdapter invoiceAdapter;

    public void create(InvoiceDTO invoiceDTO) {
        try {
            InvoiceConfiguration invoiceConfiguration = invoiceConfigurationService.findByConfigurationCode(invoiceDTO.getInvoiceConfigurationCode());
            String invoice = createInvoiceJson(invoiceDTO, invoiceConfiguration);
            invoiceAdapter.createInvoice(invoice);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void cancel(String invoiceConfigCode, InvoiceCriteriaDTO invoiceCriteriaDTO) {
        InvoiceConfiguration invoiceConfiguration = invoiceConfigurationService.findByConfigurationCode(invoiceConfigCode);

    }

    private String createInvoiceJson(InvoiceDTO invoiceDTO, InvoiceConfiguration invoiceConfiguration) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String invoiceConfigurationJson = objectMapper.writeValueAsString(invoiceConfiguration);
        ObjectNode invoiceConfigurationNode = (ObjectNode) objectMapper.readTree(invoiceConfigurationJson);
        JsonNode serviceCode = invoiceConfigurationNode.get("serviceCode");
        JsonNode entityTypeCode = invoiceConfigurationNode.get("entityTypeCode");
        JsonNode ledgerAlias = invoiceConfigurationNode.get("ledgerAlias");
        JsonNode sourceSystemCode = invoiceConfigurationNode.get("sourceSystemCode");
        JsonNode serviceProviderCode = invoiceConfigurationNode.get("serviceProviderCode");

        String invoiceJson = objectMapper.writeValueAsString(invoiceDTO);
        ObjectNode invoiceNode = (ObjectNode) objectMapper.readTree(invoiceJson);
        invoiceNode.put("sourceSystemCode", sourceSystemCode.asText());
        invoiceNode.put("serviceProviderCode", serviceProviderCode.asText());
        invoiceNode.remove("invoiceConfigurationCode");
        invoiceNode.get("invoiceLineDetail").forEach(invoiceLineDetail -> {
            ((ObjectNode)invoiceLineDetail).put("ledgerAlias", ledgerAlias.asText());
            ((ObjectNode)invoiceLineDetail).put("serviceCode", serviceCode.asText());
            ((ObjectNode)invoiceLineDetail).put("entityTypeCode", entityTypeCode.asText());
                });
        return objectMapper.writeValueAsString(invoiceNode);
    }


}
