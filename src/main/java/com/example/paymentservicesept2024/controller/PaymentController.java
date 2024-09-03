package com.example.paymentservicesept2024.controller;

import com.example.paymentservicesept2024.dto.PaymentRequestDTO;
import com.example.paymentservicesept2024.dto.PaymentResponseDTO;
import com.example.paymentservicesept2024.model.PaymentResponse;
import com.example.paymentservicesept2024.service.iPaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class PaymentController {
    private iPaymentService razorpayService;
    private iPaymentService stripeService;

    public PaymentController(@Qualifier("razorpayPaymentServiceImpl") iPaymentService razorpayService,
                             @Qualifier("stripePaymentServiceImpl") iPaymentService stripeService) {
        this.razorpayService = razorpayService;
        this.stripeService = stripeService;
    }

    @PostMapping("/payment/customer")
    public PaymentResponseDTO makePayment(@RequestBody PaymentRequestDTO paymentRequestDTO) throws RazorpayException {
        // S1. Validate the input.
        if (!isValidRequest(paymentRequestDTO)) {
            // throw exceptions from here or return ResponseEntity with proper message
        }

        // S2.
        iPaymentService paymentService = getPaymentGateway();

        // S3. call paymentService and get response
        PaymentResponse response = paymentService.initiatePayment(paymentRequestDTO.getCustomerId(),
                paymentRequestDTO.getAmount(),
                paymentRequestDTO.getOrderId());
        // S4. convert and return
        return convertToPaymentResponseDTO(response);
    }

    private PaymentResponseDTO convertToPaymentResponseDTO(PaymentResponse response) {
        return new PaymentResponseDTO();
    }

    private iPaymentService getPaymentGateway() {
        Random random = new Random();
        switch (random.nextInt(2)) {
            case 1:
                return this.razorpayService;
            case 2:
            default:
                return this.stripeService;
        }
    }

    private boolean isValidRequest(PaymentRequestDTO paymentRequestDTO) {
        return true;
    }

}
