package com.invoice.expert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.invoice.adapter.InvoiceAdapter;
import com.invoice.domain.InvoiceConfiguration;
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
            ObjectMapper objectMapper = new ObjectMapper();
            InvoiceConfiguration invoiceConfiguration = invoiceConfigurationService.findByConfigurationCode(invoiceDTO.getInvoiceConfigurationCode());
            String invoiceConfigurationJson = objectMapper.writeValueAsString(invoiceConfiguration);
            ObjectNode invoiceConfigurationNode = (ObjectNode) objectMapper.readTree(invoiceConfigurationJson);
            JsonNode serviceCode = invoiceConfigurationNode.get("serviceCode");
            JsonNode entityTypeCode = invoiceConfigurationNode.get("entityTypeCode");
            JsonNode ledgerAlias = invoiceConfigurationNode.get("ledgerAlias");
            JsonNode sourceSystemCode = invoiceConfigurationNode.get("sourceSystemCode");

            String invoiceJson = objectMapper.writeValueAsString(invoiceDTO);
            ObjectNode invoiceNode = (ObjectNode) objectMapper.readTree(invoiceJson);
            invoiceNode.put("sourceSystemCode", sourceSystemCode.asText());
            invoiceNode.remove("invoiceConfigurationCode");
            invoiceNode.get("invoiceLineDetail").forEach(invoiceLineDetail -> {
                ((ObjectNode)invoiceLineDetail).put("ledgerAlias", ledgerAlias.asText());
                ((ObjectNode)invoiceLineDetail).put("serviceCode", serviceCode.asText());
                ((ObjectNode)invoiceLineDetail).put("entityTypeCode", entityTypeCode.asText());
                    });
            invoiceAdapter.createInvoice(objectMapper.writeValueAsString(invoiceNode));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
