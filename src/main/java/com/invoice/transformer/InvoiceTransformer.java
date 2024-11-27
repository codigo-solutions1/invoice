package com.invoice.transformer;

import com.invoice.domain.InvoiceDomain;
import com.invoice.model.InvoiceModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class InvoiceTransformer {
    public InvoiceModel toModel(InvoiceDomain invoiceDomain){
        InvoiceModel model = new InvoiceModel();
        model.setId(UUID.randomUUID());
        model.setSourceSystemAppRefNo(invoiceDomain.getSourceSystemAppRefNo());
        model.setSourceSysVoucherNo(invoiceDomain.getSourceSysVoucherNo());
        model.setSourceSysAppRefDate(invoiceDomain.getSourceSysAppRefDate().toString());
        model.setPaymentConfigCode(invoiceDomain.getPaymentConfigCode());
        model.setVoucherConfigType(invoiceDomain.getVoucherConfigType());
        model.setFullName(invoiceDomain.getFullName());
        model.setPhoneNumber(invoiceDomain.getPhoneNumber());
        model.setEmail(invoiceDomain.getEmail());
        model.setCustomerType(invoiceDomain.getCustomerType());
        model.setFees(invoiceDomain.getFees());
        model.setQuantity(invoiceDomain.getQuantity());
        model.setLanguage(invoiceDomain.getLanguage());
        return model;
    }

    public InvoiceDomain toEntity(InvoiceModel invoiceModel){
        InvoiceDomain invoiceDomain = new InvoiceDomain();
        invoiceDomain.setId(UUID.randomUUID());
        invoiceDomain.setSourceSystemAppRefNo(invoiceModel.getSourceSystemAppRefNo());
        invoiceDomain.setSourceSysVoucherNo(invoiceModel.getSourceSysVoucherNo());
        invoiceDomain.setSourceSysAppRefDate(LocalDateTime.parse(invoiceModel.getSourceSysAppRefDate().toString()));
        invoiceDomain.setPaymentConfigCode(invoiceModel.getPaymentConfigCode());
        invoiceDomain.setVoucherConfigType(invoiceModel.getVoucherConfigType());
        invoiceDomain.setFullName(invoiceModel.getFullName());
        invoiceDomain.setPhoneNumber(invoiceModel.getPhoneNumber());
        invoiceDomain.setEmail(invoiceModel.getEmail());
        invoiceDomain.setCustomerType(invoiceModel.getCustomerType());
        invoiceDomain.setFees(invoiceModel.getFees());
        invoiceDomain.setQuantity(invoiceModel.getQuantity());
        invoiceDomain.setLanguage(invoiceModel.getLanguage());
        return invoiceDomain;
    }

}
