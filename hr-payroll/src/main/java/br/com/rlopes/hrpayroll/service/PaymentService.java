package br.com.rlopes.hrpayroll.service;

import org.springframework.stereotype.Service;

import br.com.rlopes.hrpayroll.entity.Payment;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment("João", 200.0, days);
    }
}
