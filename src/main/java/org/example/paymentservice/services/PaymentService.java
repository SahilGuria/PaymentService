package org.example.paymentservice.services;


import com.razorpay.RazorpayException;

public interface PaymentService {
    public String initiatePayment(Long orderId, String name, double amount) throws RazorpayException;

}
