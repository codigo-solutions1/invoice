package com.invoice.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            stmt = conn.prepareCall("{call process_invoice(?)}");
            stmt.setString(1, invoice);
            stmt.execute();
        } catch (SQLException e) {
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
}
