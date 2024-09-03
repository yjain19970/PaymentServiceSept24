package com.example.paymentservicesept2024.controller.webhook;

import com.example.paymentservicesept2024.dto.webhook.RazorpayWebhookRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazorpayWebhook {

    @PostMapping("/webhook/razorpay")
    public void orderStatus(@RequestBody RazorpayWebhookRequestDTO webhookRequestDTO) {
        // Do whatever you want on the basis of the eventId

        /**
         * if(event == success) {
         *     // do something
         *     // return order.status as success ->
         * }else if(event==failed due to cvv error){
         * }else if(event == fialed due to wrong credentails){
         *
         * }
         *
         *
         */
    }

    // callbackURL: your-application-domain/webhook/razorpay [POST]

}
