package org.example.paymentservice.services.paymentGateway;

import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

@Service("razorpaypaymentlink")
public interface PaymentGateway {
     String generatePaymentLink(Long orderId, String name, double amount) throws RazorpayException;
     boolean validatePayment(Long orderId);
}
