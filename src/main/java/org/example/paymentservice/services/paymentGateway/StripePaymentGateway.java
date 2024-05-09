package org.example.paymentservice.services.paymentGateway;

public class StripePaymentGateway implements PaymentGateway{
    @Override
    public String generatePaymentLink(Long orderId, String name, double amount) {
        return "";
    }

    @Override
    public boolean validatePayment(Long orderId) {
        return false;
    }
}
