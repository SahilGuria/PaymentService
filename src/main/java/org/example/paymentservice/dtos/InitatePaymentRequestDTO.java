package org.example.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitatePaymentRequestDTO {
    private Long orderId;
    private String name;
    private double amount;
}
