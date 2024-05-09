package org.example.paymentservice.services;

import org.example.paymentservice.services.paymentGateway.PaymentGateway;
import org.example.paymentservice.services.paymentGateway.RazorpayPaymentLink;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentGateway paymentGateway;
    public PaymentServiceImpl(@Qualifier("razorpaymentgateway") PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public String initiatePayment(Long orderId, String name, double amount) {
        return paymentGateway.generatePaymentLink(
                orderId,
                name,
                amount
        );
    }
}
