package com.invoice.repository;

import com.invoice.domain.Invoice;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;
//TODO CHANGE DATABASE
public interface InvoiceRepository extends MongoRepository<Invoice, UUID> {
    Invoice save(Invoice invoice);
}

