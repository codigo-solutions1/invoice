package com.invoice.repository;

import com.invoice.domain.invoice.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface InvoiceRepository extends MongoRepository<Invoice, UUID> {
}
