package com.invoice.transformer;

import com.invoice.domain.invoice.CustomerDetail;
import com.invoice.dto.invoice.CustomerDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerDetailTransformer implements Transformer<CustomerDetailDTO, CustomerDetail> {

    @Override
    public CustomerDetail toEntity(CustomerDetailDTO model) {

        CustomerDetail.CustomerDetailBuilder builder = CustomerDetail.builder();
        builder.authenticated(model.getAuthenticated());

        if (model.getAuthenticated()) {
            builder.customerType(model.getCustomerType());
            builder.umUserId(model.getUmUserId());
            builder.licenseNo(model.getLicenseNo());
        } else {
            builder.fullName(model.getFullName());
            builder.phoneNumber(model.getPhoneNumber());
            builder.email(model.getEmail());
            builder.emiratesId(model.getEmiratesId());
        }

        return builder.build();
    }

    @Override
    public CustomerDetailDTO toModel(CustomerDetail entity) {

        CustomerDetailDTO dto = new CustomerDetailDTO();
        dto.setAuthenticated(entity.getAuthenticated());

        if (entity.getAuthenticated()) {
            dto.setCustomerType(entity.getCustomerType());
            dto.setUmUserId(entity.getUmUserId());
            dto.setLicenseNo(entity.getLicenseNo());
        } else {
            dto.setFullName(entity.getFullName());
            dto.setPhoneNumber(entity.getPhoneNumber());
            dto.setEmail(entity.getEmail());
            dto.setEmiratesId(entity.getEmiratesId());
        }

        return dto;
    }
}
