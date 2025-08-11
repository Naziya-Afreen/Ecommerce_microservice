package com.example.paymentservice.service;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.model.PaymentStatus;
import com.example.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment paymentRequest) {
        // Assign transaction ID
        paymentRequest.setTransactionId(UUID.randomUUID().toString());
        paymentRequest.setStatus(PaymentStatus.SUCCESS); // Here you can integrate with real gateway
        return paymentRepository.save(paymentRequest);
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }
}
