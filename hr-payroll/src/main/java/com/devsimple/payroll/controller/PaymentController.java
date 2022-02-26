package com.devsimple.payroll.controller;

import com.devsimple.payroll.model.Payment;
import com.devsimple.payroll.services.PaymentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private static final String PAYMENT_SERVICE = "paymentService";

    @Autowired
    private PaymentService paymentService;

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,
                                              @PathVariable Integer days){
        Payment payment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<String> getPaymentAlternative(Exception e){
        return new ResponseEntity<String>("Server is down!", HttpStatus.OK);
    }
}
