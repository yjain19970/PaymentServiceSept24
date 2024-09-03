package com.example.paymentservicesept2024.service.webhook;

import com.example.paymentservicesept2024.dto.webhook.StripeWebhookRequestDTO;

public interface iStripeWebhookService {
    void processEvent(StripeWebhookRequestDTO dto);
}
