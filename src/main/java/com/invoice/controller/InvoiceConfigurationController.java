package com.invoice.controller;

import com.invoice.dto.configuration.InvoiceConfigurationResponseDTO;
import com.invoice.handler.InvoiceConfigurationHandler;
import com.invoice.dto.configuration.InvoiceConfigurationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@Tag(name = "Invoice Configuration Controller", description = "API for managing invoice configurations")
@RestController
@RequiredArgsConstructor
@RequestMapping("/invoices/configurations")
public class InvoiceConfigurationController {

    private final InvoiceConfigurationHandler invoiceConfigurationHandler;


    @Operation(
            summary = "Create a new invoice configuration",
            description = "This endpoint allows you to create a new invoice configuration.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Invoice configuration created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")
            }
    )
    @PostMapping
    public ResponseEntity<InvoiceConfigurationResponseDTO> createInvoiceConfigurations(
            @Valid @RequestBody InvoiceConfigurationDTO invoiceConfigurationDTO) {
        InvoiceConfigurationResponseDTO response = invoiceConfigurationHandler.createInvoiceConfiguration(invoiceConfigurationDTO);
        return ResponseEntity.ok(response);
    }
}