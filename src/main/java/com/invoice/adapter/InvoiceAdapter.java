package com.invoice.adapter;

import com.invoice.domain.invoice.Invoice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Component
@RequiredArgsConstructor
public class InvoiceAdapter {

    @Value("${url}")
    private String apiUrl;

    public void createInvoice(Invoice invoice) {
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
            log.error("Error calling create invoice API: {}{}", e.getMessage());
            throw new RuntimeException("Failed to create invoice via API", e);
        }
    }

    public void cancelInvoice(String invoice) {
    }
}
