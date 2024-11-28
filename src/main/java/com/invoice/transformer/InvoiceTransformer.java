package com.invoice.transformer;

import com.invoice.domain.InvoiceDomain;
import com.invoice.model.invoice.InvoiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class InvoiceTransformer implements InvoiceInterface <InvoiceModel, InvoiceDomain> {
   @Override
    public InvoiceDomain toEntity(InvoiceModel model) {
        return InvoiceDomain.builder()
                .id(model.getId())
                .sourceSystemAppRefNo(model.getSourceSystemAppRefNo())
                .sourceSysVoucherNo(model.getSourceSysVoucherNo())
                .sourceSysAppRefDate(LocalDateTime.parse(model.getSourceSysAppRefDate()))
                .paymentConfigCode(model.getPaymentConfigCode())
                .voucherConfigType(model.getVoucherConfigType())
                .fullName(model.getFullName())
                .phoneNumber(model.getPhoneNumber())
                .email(model.getEmail())
                .customerType(model.getCustomerType())
                .licenseNumber(model.getLicenseNumber())
                .userId(model.getUserId())
                .fees(model.getFees())
                .quantity(model.getQuantity())
                .language(model.getLanguage())
                .build();
    }

@Override
    public InvoiceModel toModel(InvoiceDomain entity) {
        return InvoiceModel.builder()
                .id(entity.getId())
                .sourceSystemAppRefNo(entity.getSourceSystemAppRefNo())
                .sourceSysVoucherNo(entity.getSourceSysVoucherNo())
                .sourceSysAppRefDate(String.valueOf(entity.getSourceSysAppRefDate()))
                .paymentConfigCode(entity.getPaymentConfigCode())
                .voucherConfigType(entity.getVoucherConfigType())
                .fullName(entity.getFullName())
                .phoneNumber(entity.getPhoneNumber())
                .email(entity.getEmail())
                .customerType(entity.getCustomerType())
                .licenseNumber(entity.getLicenseNumber())
                .userId(entity.getUserId())
                .fees(entity.getFees())
                .quantity(entity.getQuantity())
                .language(entity.getLanguage())
                .build();
    }



}

