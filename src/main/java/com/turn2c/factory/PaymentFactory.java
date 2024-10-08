package com.turn2c.factory;

import com.turn2c.domain.enums.PaymentTypeEnum;
import com.turn2c.service.PaymentService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class PaymentFactory {

    private final Map<String, PaymentService> mapPaymentService;

    public PaymentService getPaymentService(PaymentTypeEnum paymentType) {

        var name = "PAYMENT_" + paymentType.name();
        if (!mapPaymentService.containsKey(name)) throw new IllegalArgumentException("Payment type not found");
        return mapPaymentService.get(name);
    }
}
