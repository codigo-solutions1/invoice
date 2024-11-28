package com.invoice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invoice.dto.invoice.InvoiceDTO;
import com.invoice.dto.invoice.CustomerDetailDTO;
import com.invoice.domain.Invoice;
import com.invoice.repository.InvoiceRepository;
import com.invoice.service.InvoiceService;
import com.invoice.validation.CustomerDetailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    @Override
    public Invoice saveInvoice(InvoiceDTO dto) {
        Invoice invoice = new Invoice();
        invoice.setId(dto.getId());
        invoice.setSourceSystemAppRefNo(dto.getSourceSystemAppRefNo());
        invoice.setSourceSysVoucherNo(dto.getSourceSysVoucherNo());
        invoice.setSourceSysAppRefDate(dto.getSourceSysAppRefDate());
        invoice.setInvoiceConfigCode(dto.getInvoiceConfigCode());
        invoice.setDescription(dto.getDescription());
        invoice.setLanguage(dto.getLanguage());

        // Validate and convert DTOs to JSON strings
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CustomerDetailValidator validator = new CustomerDetailValidator();
            CustomerDetailDTO validatedCustomerDetail = validator.validateCustomerDetail(dto.getCustomerDetail());

            // Serialize validated customer detail to JSON
            invoice.setCustomerDetail(objectMapper.writeValueAsString(validatedCustomerDetail));

            // Serialize invoice line details to JSON
            List<String> invoiceLineDetailsJson = dto.getInvoiceLineDetail()
                    .stream()
                    .map(detail -> {
                        try {
                            return objectMapper.writeValueAsString(detail);
                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                            return null;
                        }
                    })
                    .collect(Collectors.toList());
            invoice.setInvoiceLineDetail(invoiceLineDetailsJson);

            // Serialize reserve attributes to JSON
            invoice.setReserveAttribute(objectMapper.writeValueAsString(dto.getReserveAttribute()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // Handle the exception properly in a real-world scenario
        }

        return repository.save(invoice);
    }
}
