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
        if (model == null) {
            return null;
        }

        return CustomerDetail.builder()
                .authenticated(model.getAuthenticated())
                .customerType(model.getCustomerType())
                .umUserId(model.getUmUserId())
                .licenseNo(model.getLicenseNo())
                .fullName(model.getFullName())
                .phoneNumber(model.getPhoneNumber())
                .email(model.getEmail())
                .emiratesId(model.getEmiratesId())
                .build();
    }

    @Override
    public CustomerDetailDTO toModel(CustomerDetail entity) {
        if (entity == null) {
            return null;
        }

        CustomerDetailDTO dto = new CustomerDetailDTO();
        dto.setAuthenticated(entity.getAuthenticated());
        dto.setCustomerType(entity.getCustomerType());
        dto.setUmUserId(entity.getUmUserId());
        dto.setLicenseNo(entity.getLicenseNo());
        dto.setFullName(entity.getFullName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        dto.setEmiratesId(entity.getEmiratesId());
        return dto;
    }
}
