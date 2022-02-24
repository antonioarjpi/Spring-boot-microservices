package com.devsimple.payroll.services;

import com.devsimple.payroll.model.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {

    public Payment getPayment(Long workerId, int days){
        return new Payment("Bob", 200.0, days);
    }

}
