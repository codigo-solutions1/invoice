package com.invoice.validator;

import com.invoice.dto.invoice.CustomerDetailDTO;
import com.invoice.dto.invoice.InvoiceDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class InvoiceValidator {

    public void validate(InvoiceDTO invoiceDTO) {
        validateCustomerDetails(invoiceDTO);
    }

    private static void validateCustomerDetails(InvoiceDTO invoiceDTO) {
        CustomerDetailDTO customerDetailDTO = invoiceDTO.getCustomerDetail();
        if (customerDetailDTO.getAuthenticated()) {
            assert StringUtils.isNoneBlank(customerDetailDTO.getCustomerType()) : "Customer Type cannot be empty or null";
            assert StringUtils.isNoneBlank(customerDetailDTO.getUmUserId()) : "UM User Id cannot be empty or null";
            assert StringUtils.isNoneBlank(customerDetailDTO.getLicenseNo()) : "License Number cannot be empty or null";
        } else {
            assert StringUtils.isNoneBlank(customerDetailDTO.getFullName()) : "Full Name cannot be empty or null";
            assert StringUtils.isNoneBlank(customerDetailDTO.getPhoneNumber()) : "Phone Number cannot be empty or null";
            assert StringUtils.isNoneBlank(customerDetailDTO.getEmail()) : "Email cannot be empty or null";
            assert StringUtils.isNoneBlank(customerDetailDTO.getEmiratesId()) : "Emirates ID cannot be empty or null";
        }
    }
}

