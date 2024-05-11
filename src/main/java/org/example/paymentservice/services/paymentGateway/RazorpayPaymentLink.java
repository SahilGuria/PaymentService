package org.example.paymentservice.services.paymentGateway;

import com.razorpay.PaymentLink;
import org.example.paymentservice.services.PaymentService;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;


@Service("razorpaypaymentlink")
public class RazorpayPaymentLink implements PaymentGateway {

     RazorpayClient razorpay;
     public RazorpayPaymentLink(RazorpayClient razorpayClient) {
         this.razorpay= razorpayClient;
     }

    @Override
    public String generatePaymentLink(Long orderId, String name, double amount) throws RazorpayException {


//        RazorpayClient razorpay = new RazorpayClient("[YOUR_KEY_ID]", "[YOUR_KEY_SECRET]");
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",100);
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1715439317);
        paymentLinkRequest.put("reference_id",orderId.toString());
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name",name);
        customer.put("contact","8787878787");
        customer.put("email","sumosteve053@gmail.com.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Random Payment");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://youtube.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }

    @Override
    public boolean validatePayment(Long orderId) {
        return false;
    }
}
