package com.example.paymentservicesept2024.service;

import com.example.paymentservicesept2024.model.PaymentResponse;
import com.razorpay.RazorpayException;

public interface iPaymentService {
    PaymentResponse initiatePayment(String customerId, String amount, String orderId) throws RazorpayException;
}
