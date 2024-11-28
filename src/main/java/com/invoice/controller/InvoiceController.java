package com.invoice.controller;

import com.invoice.handler.InvoiceHandler;
import com.invoice.dto.invoice.InvoiceDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Invoice Controller", description = "API for managing invoices")
@RestController
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceHandler invoiceHandler;


    @Operation(
            summary = "Create a new invoice configuration",
            description = "This endpoint allows you to create a new invoice configuration.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Invoice configuration created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")
            }
    )
    @PostMapping
    public ResponseEntity createInvoice(
            @Parameter(description = "Invoice configuration data to be created", required = true)
            @RequestBody InvoiceDTO invoiceDTO) {
        InvoiceDTO invoice = invoiceHandler.createInvoice(invoiceDTO);
        return ResponseEntity.ok(invoice);
    }
}


