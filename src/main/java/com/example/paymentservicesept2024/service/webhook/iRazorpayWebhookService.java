package com.example.paymentservicesept2024.service.webhook;

import com.example.paymentservicesept2024.dto.webhook.RazorpayWebhookRequestDTO;

public interface iRazorpayWebhookService {
    void processEvent(RazorpayWebhookRequestDTO dto);
}
