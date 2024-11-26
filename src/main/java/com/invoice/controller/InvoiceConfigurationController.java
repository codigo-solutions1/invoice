package com.invoice.controller;

import com.invoice.handler.InvoiceConfigurationHandler;
import com.invoice.model.InvoiceConfigurationModel;
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

@Tag(name = "Invoice Configuration Controller", description = "API for managing invoice configurations")
@RestController
@RequiredArgsConstructor
@RequestMapping("/payments/configurations")
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
    public ResponseEntity createInvoiceConfigurations(
            @Parameter(description = "Invoice configuration data to be created", required = true)
            @RequestBody InvoiceConfigurationModel invoiceConfigurationModel) {
        InvoiceConfigurationModel configurationFromDB = invoiceConfigurationHandler.createInvoiceConfiguration(invoiceConfigurationModel);
        return ResponseEntity.ok(configurationFromDB);
    }
}

