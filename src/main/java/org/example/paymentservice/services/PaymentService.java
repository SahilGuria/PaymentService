package org.example.paymentservice.services;


public interface PaymentService {
    public String initiatePayment(Long orderId, String name, double amount);

}
