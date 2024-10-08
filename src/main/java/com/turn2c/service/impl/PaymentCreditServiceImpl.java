package com.turn2c.service.impl;

import com.turn2c.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("PAYMENT_CREDIT_CARD")
@RequiredArgsConstructor
public class PaymentCreditServiceImpl implements PaymentService {

    @Override
    public void pagar(Long id) {
        log.info("Pagando com cartão de crédito");
    }
}
