package com.invoice.adapter;

import com.invoice.dto.OutstandingInvoiceDTO;
import com.invoice.dto.OutstandingInvoiceResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class InvoiceAdapter {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUser;

    @Value("${db.password}")
    private String dbPass;

    public void createInvoice(String invoice) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            stmt = conn.prepareCall("{call process_invoice(?)}");
            stmt.setString(1, invoice);
            stmt.execute();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public void cancelInvoice(String invoice) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            stmt = conn.prepareCall("{call process_invoice(?)}");
            stmt.setString(1, invoice);
            stmt.execute();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    public void inquireInvoice(String invoice) {
    }

    public OutstandingInvoiceResponseDTO getInvoicesByCriteria(String userId, OutstandingInvoiceDTO request) {
        List<OutstandingInvoiceDTO> invoices = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            String query = "SELECT * FROM INVOICES WHERE USER_ID = ? AND INVOICE_NUMBER = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, userId);
            stmt.setString(2, request.getInvoiceNumber());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) { OutstandingInvoiceDTO invoice = OutstandingInvoiceDTO.builder()
                    .invoiceNumber(rs.getString("INVOICE_NUMBER"))
                    .description(rs.getString("DESCRIPTION"))
                    .invoiceAmount(rs.getBigDecimal("INVOICE_AMOUNT"))
                    .pendingAmount(rs.getBigDecimal("PENDING_AMOUNT"))
                    .invoiceDate(rs.getString("INVOICE_DATE"))
                    .sourceSysRefNumber(rs.getString("SOURCE_SYS_REF_NUMBER"))
                    .serviceName(rs.getString("SERVICE_NAME"))
                    .build();
                invoices.add(invoice);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                } if (conn != null) {
                    conn.close(); }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        return OutstandingInvoiceResponseDTO.builder().outStandingInvoices(invoices).build();
    }

}
