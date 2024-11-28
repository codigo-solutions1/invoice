package com.invoice.validation;

import com.invoice.dto.invoice.CustomerDetailDTO;

public class CustomerDetailValidator {

    public CustomerDetailDTO validateCustomerDetail(CustomerDetailDTO customerDetail) {
        CustomerDetailDTO validatedCustomerDetail = new CustomerDetailDTO();

        validatedCustomerDetail.setAuthenticated(customerDetail.getAuthenticated());

        if (Boolean.TRUE.equals(customerDetail.getAuthenticated())) {
            validatedCustomerDetail.setCustomerType(customerDetail.getCustomerType());
            validatedCustomerDetail.setUmUserId(customerDetail.getUmUserId());
            validatedCustomerDetail.setLicenseNo(customerDetail.getLicenseNo());
        } else {
            validatedCustomerDetail.setFullName(customerDetail.getFullName());
            validatedCustomerDetail.setPhoneNumber(customerDetail.getPhoneNumber());
            validatedCustomerDetail.setEmail(customerDetail.getEmail());
            validatedCustomerDetail.setEmiratesId(customerDetail.getEmiratesId());
        }

        return validatedCustomerDetail;
    }
}

