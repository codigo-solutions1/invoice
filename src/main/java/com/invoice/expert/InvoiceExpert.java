package com.invoice.expert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.invoice.adapter.InvoiceAdapter;
import com.invoice.domain.InvoiceConfiguration;
import com.invoice.dto.InvoiceConfigurationDTO;
import com.invoice.dto.invoice.InvoiceDTO;
import com.invoice.repository.InvoiceConfigurationRepository;
import com.invoice.service.InvoiceConfigurationService;
import com.invoice.transformer.InvoiceConfigurationTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InvoiceExpert {

    private final InvoiceConfigurationService invoiceConfigurationService;
    private final InvoiceAdapter invoiceAdapter;
    private final InvoiceConfigurationTransformer transformer;

    public void create(InvoiceDTO invoiceDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InvoiceConfiguration invoiceConfiguration = invoiceConfigurationService.findByConfigurationCode(invoiceDTO.getInvoiceConfigCode());
            InvoiceConfigurationDTO invoiceConfigurationDTO = transformer.toModel(invoiceConfiguration);
            invoiceDTO.setInvoiceConfigurationDTO(invoiceConfigurationDTO);
            String invoice = objectMapper.writeValueAsString(invoiceDTO);
            invoiceAdapter.createInvoice(invoice);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
