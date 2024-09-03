package com.example.paymentservicesept2024.service;

import com.example.paymentservicesept2024.model.PaymentResponse;
import org.springframework.stereotype.Service;

@Service("razorpayPaymentServiceImpl")
public class RazorpayPaymentServiceImpl implements iPaymentService {
    @Override
    public PaymentResponse initiatePayment(String customerId, String amount, String orderId) {
        // call razorpay
        // response = created_order_in_razorpay create_order_api of razorpay..

        //
        return new PaymentResponse();
    }
}
