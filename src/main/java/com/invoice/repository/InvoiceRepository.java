package com.invoice.repository;

import com.invoice.domain.InvoiceDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<InvoiceDomain, UUID> {

}
