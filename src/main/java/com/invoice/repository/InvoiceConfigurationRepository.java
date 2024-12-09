package com.invoice.repository;

import com.invoice.domain.InvoiceConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


@Component
public interface InvoiceConfigurationRepository extends MongoRepository<InvoiceConfiguration, String> {

    boolean existsByInvoiceConfigurationCodeAndSourceSystemCode(String invoiceConfigurationCode, String sourceSystemCode);

    InvoiceConfiguration findByInvoiceConfigurationCode(String code);
}


