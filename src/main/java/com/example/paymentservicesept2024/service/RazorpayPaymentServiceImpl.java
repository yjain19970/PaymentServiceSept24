package com.example.paymentservicesept2024.service;

import com.example.paymentservicesept2024.model.PaymentResponse;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorpayPaymentServiceImpl")
public class RazorpayPaymentServiceImpl implements iPaymentService {
    private RazorpayClient razorpayClient;

    public RazorpayPaymentServiceImpl(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public PaymentResponse initiatePayment(String customerId, String amount, String orderId) throws RazorpayException {
        //S1.
        JSONObject orderRequest = createOrderRequestForRazorpay(customerId, amount, orderId);
        Order order = razorpayClient.orders.create(orderRequest);
        return new PaymentResponse(order);
    }

    @NotNull
    private JSONObject createOrderRequestForRazorpay(String customerId, String amount, String orderId) {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "some_receipt_random_number");
        return orderRequest;
    }
}
