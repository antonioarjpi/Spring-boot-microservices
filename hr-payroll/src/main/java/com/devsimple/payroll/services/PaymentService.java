package com.devsimple.payroll.services;

import com.devsimple.payroll.feign.WorkerFeignClient;
import com.devsimple.payroll.model.Payment;
import com.devsimple.payroll.model.Worker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class PaymentService {

    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days){

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
