package com.invoice.controller;

import com.invoice.dto.ResponseDTO;
import com.invoice.dto.invoice.CancelInvoiceDTO;
import com.invoice.dto.invoice.InvoiceDTO;
import com.invoice.handler.CancelInvoiceHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cancel Invoice Controller", description = "API for cancel invoices")
@RestController
@RequiredArgsConstructor
@RequestMapping("/invoiceCancel")
public class cancelInvoice {

    private final CancelInvoiceHandler cancelInvoiceHandler;


    @Operation(summary = "Cancel invoice", description = "This endpoint allows you to cancel invoice.", responses = {@ApiResponse(responseCode = "200", description = "Canceled invoice successfully"), @ApiResponse(responseCode = "400", description = "Invalid input data")})
    @PostMapping
    public ResponseEntity<ResponseDTO> cancelInvoiceInvoice(@RequestBody CancelInvoiceDTO cancelInvoiceDTO) {
        ResponseDTO response = cancelInvoiceHandler.cancelInvoice(cancelInvoiceDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}


