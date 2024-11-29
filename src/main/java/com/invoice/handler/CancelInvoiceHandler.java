package com.invoice.handler;

import com.invoice.dto.ResponseDTO;
import com.invoice.dto.invoice.CancelInvoiceDTO;
import com.invoice.expert.CancelInvoiceExpert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CancelInvoiceHandler {
    private final CancelInvoiceExpert cancelInvoiceExpert;


    public ResponseDTO cancelInvoice(CancelInvoiceDTO cancelInvoiceDTO) {
        cancelInvoiceExpert.cancel(cancelInvoiceDTO);
        return new ResponseDTO();
    }
}
