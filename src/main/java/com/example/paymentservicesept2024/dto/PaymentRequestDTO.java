package com.example.paymentservicesept2024.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentRequestDTO {
    private String customerId;
    private String orderId;
    private String amount;
}
