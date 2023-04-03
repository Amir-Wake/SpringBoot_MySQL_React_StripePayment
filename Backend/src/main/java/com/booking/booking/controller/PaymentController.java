package com.booking.booking.controller;

import com.booking.booking.dto.CreatePayment;
import com.booking.booking.dto.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class PaymentController {


    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntend (@RequestBody CreatePayment createPayment) throws StripeException {

            PaymentIntentCreateParams params =
                    PaymentIntentCreateParams.builder()
                            .setAmount(12*100L)
                            .setCurrency("gbp")
                            .setAutomaticPaymentMethods(
                                    PaymentIntentCreateParams.AutomaticPaymentMethods
                                            .builder()
                                            .setEnabled(true)
                                            .build()
                            )
                            .build();

            // Create a PaymentIntent with the order amount and currency
            PaymentIntent paymentIntent = PaymentIntent.create(params);

            return new CreatePaymentResponse(paymentIntent.getClientSecret());
    }
}
