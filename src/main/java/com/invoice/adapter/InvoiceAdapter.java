package com.invoice.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class InvoiceAdapter {

    @Value("${url}")
    private String apiUrl;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUser;

    @Value("${db.password}")
    private String dbPass;

    public void createInvoice(String invoice) {
        String url = apiUrl + "/create-invoice";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"invoice\": \"" + invoice + "\"}"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response: " + response.body());
        } catch (Exception e) {
            System.out.println("Error calling create invoice API: {}" + e.getMessage());
            throw new RuntimeException("Failed to create invoice via API", e);
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
}
