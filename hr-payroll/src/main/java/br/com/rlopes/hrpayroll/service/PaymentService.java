package br.com.rlopes.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.rlopes.hrpayroll.entity.Payment;
import br.com.rlopes.hrpayroll.entity.Worker;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @NonNull
    private final RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days) {
        Map<String, String> uriVariables = new HashMap<>(Map.of("id", "" + workerId));

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

        return new Payment( worker.getName(), worker.getDailyIncome() , days);
    }
}
