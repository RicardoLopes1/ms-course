package br.com.rlopes.hrpayroll.service;

import org.springframework.stereotype.Service;

import br.com.rlopes.hrpayroll.entity.Payment;
import br.com.rlopes.hrpayroll.entity.Worker;
import br.com.rlopes.hrpayroll.feignClients.WorkerFeignClient;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
