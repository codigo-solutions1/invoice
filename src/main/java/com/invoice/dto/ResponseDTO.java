package com.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {
    private String responseCode;
    private String description;

    public static ResponseDTO success() {
        return ResponseDTO.builder()
                .responseCode("200")
                .description("Success")
                .build();
    }
}
