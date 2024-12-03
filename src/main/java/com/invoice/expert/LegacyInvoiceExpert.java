package com.invoice.expert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.invoice.adapter.InvoiceAdapter;
import com.invoice.adapter.InvoiceAdapter;
import com.invoice.domain.InvoiceConfiguration;
import com.invoice.domain.invoice.Invoice;
import com.invoice.dto.InvoiceCriteriaDTO;
import com.invoice.dto.invoice.InvoiceDTO;
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
            InvoiceConfiguration invoiceConfiguration = invoiceConfigurationService.findByConfigurationCode(invoice.getConfigurationCode());
//            invoiceAdapter.createInvoice(invoice);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void cancel(String invoiceConfigCode, InvoiceCriteriaDTO invoiceCriteriaDTO) {
        try {
            invoiceConfigurationService.findByConfigurationCode(invoiceConfigCode);
            ObjectMapper objectMapper = new ObjectMapper();
            String invoiceJson = objectMapper.writeValueAsString(invoiceCriteriaDTO);
//            invoiceAdapter.cancelInvoice(invoiceJson);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private String createInvoiceJson(InvoiceDTO invoiceDTO, InvoiceConfiguration invoiceConfiguration) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String invoiceJson = objectMapper.writeValueAsString(invoiceDTO);
        ObjectNode invoiceNode = (ObjectNode) objectMapper.readTree(invoiceJson);
        invoiceNode.put("sourceSystemCode", invoiceConfiguration.getSourceSystemCode());
        invoiceNode.put("serviceProviderCode", invoiceConfiguration.getServiceProviderCode());
        invoiceNode.remove("invoiceConfigurationCode");
        invoiceNode.get("invoiceLineDetail").forEach(invoiceLineDetail -> {
            ((ObjectNode) invoiceLineDetail).put("ledgerAlias", invoiceConfiguration.getLedgerAlias());
            ((ObjectNode) invoiceLineDetail).put("serviceCode", invoiceConfiguration.getServiceCode());
            ((ObjectNode) invoiceLineDetail).put("entityTypeCode", invoiceConfiguration.getEntityTypeCode());
        });
        return objectMapper.writeValueAsString(invoiceNode);
    }


}
