package org.example.paymentservice.controller;

import org.example.paymentservice.dtos.InitiatePaymentRequestDTO;
import org.example.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
  public PaymentController(PaymentService paymentService){
      this.paymentService = paymentService;
  }

  @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDTO requestDto) {
      String payment= null;
      try {
          payment = paymentService.initiatePayment(
                  requestDto.getOrderId(),
                  requestDto.getName(),
                  requestDto.getAmount()
          );
      }catch (Exception e){
         System.out.println(e.getMessage());
      }
      return payment;
  }
}
