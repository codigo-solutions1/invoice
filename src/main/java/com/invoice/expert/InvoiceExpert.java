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

import java.util.HashMap;
import java.util.Map;

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
        try {
            InvoiceConfiguration invoiceConfiguration = invoiceConfigurationService.findByConfigurationCode(invoiceConfigCode);
            String invoice = cancelInvoiceJson(invoiceCriteriaDTO, invoiceConfiguration);
            invoiceAdapter.cancelInvoice(invoice);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private String cancelInvoiceJson(InvoiceCriteriaDTO invoiceCriteriaDTO, InvoiceConfiguration invoiceConfiguration) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> invoiceMap = new HashMap<>();
        invoiceMap.put("sourceSysChannel", invoiceCriteriaDTO.getSourceSysChannel());
        invoiceMap.put("ERADVoucherRefNo", invoiceCriteriaDTO.getERADVoucherRefNo());
        String invoiceConfigJson = objectMapper.writeValueAsString(invoiceConfiguration);
        invoiceMap.put("invoiceConfiguration", objectMapper.readTree(invoiceConfigJson));
        return objectMapper.writeValueAsString(invoiceMap);
    }

    private String createInvoiceJson(InvoiceDTO invoiceDTO, InvoiceConfiguration invoiceConfiguration) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String invoiceJson = objectMapper.writeValueAsString(invoiceDTO);
        ObjectNode invoiceNode = (ObjectNode) objectMapper.readTree(invoiceJson);
        invoiceNode.put("sourceSystemCode", invoiceConfiguration.getSourceSystemCode());
        invoiceNode.put("serviceProviderCode", invoiceConfiguration.getServiceProviderCode());
        invoiceNode.remove("invoiceConfigurationCode");
        invoiceNode.get("invoiceLineDetail").forEach(invoiceLineDetail -> {
            ((ObjectNode)invoiceLineDetail).put("ledgerAlias", invoiceConfiguration.getLedgerAlias());
            ((ObjectNode)invoiceLineDetail).put("serviceCode", invoiceConfiguration.getServiceCode());
            ((ObjectNode)invoiceLineDetail).put("entityTypeCode", invoiceConfiguration.getEntityTypeCode());
                });
        return objectMapper.writeValueAsString(invoiceNode);
    }


}
