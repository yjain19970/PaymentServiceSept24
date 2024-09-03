package com.example.paymentservicesept2024.service;

import com.example.paymentservicesept2024.model.PaymentResponse;
import org.springframework.stereotype.Service;

@Service("stripePaymentServiceImpl")
public class StripePaymentServiceImpl implements iPaymentService {
    @Override
    public PaymentResponse initiatePayment(String customerId, String amount, String orderId) {
        return null;
    }
}
