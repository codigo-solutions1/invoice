package com.invoice.controller;

import com.invoice.dto.*;
import com.invoice.dto.invoice.InvoiceDTO;
import com.invoice.handler.InvoiceHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Invoice Controller", description = "API for managing invoices")
@RestController
@RequiredArgsConstructor
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceHandler invoiceHandler;

    @Operation(summary = "Create a new invoice configuration",
            description = "This endpoint allows you to create a new invoice configuration.",
            responses = {@ApiResponse(responseCode = "200", description = "Invoice configuration created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")})
    @PostMapping
    public ResponseEntity<InvoiceResponseDTO> createInvoice(@RequestBody InvoiceDTO request) {
        InvoiceResponseDTO response = invoiceHandler.createInvoice(request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cancel invoice", description = "This endpoint allows you to cancel an invoice.",
            responses = {@ApiResponse(responseCode = "200", description = "Canceled invoice successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")})
    @PostMapping("/cancel")
    public ResponseEntity<ResponseDTO> cancelInvoice(@RequestBody CancelInvoiceCriteriaDTO request) {
        ResponseDTO response = invoiceHandler.cancelInvoice(request);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @Operation(summary = "Inquire invoice", description = "This endpoint allows you to inquire an invoice.",
            responses = {@ApiResponse(responseCode = "200", description = "Inquire invoice successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")})
    @PostMapping("/inquire")
    public ResponseEntity<InquireInvoiceResponseDTO> inquireInvoice(@RequestBody InquireInvoiceCriteriaDTO request) {
        InquireInvoiceResponseDTO response = invoiceHandler.inquireInvoice(request);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
