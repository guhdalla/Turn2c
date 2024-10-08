package com.turn2c.dto.request;

import com.turn2c.domain.enums.PaymentTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagarConsorcioRequestDto {

    @NotNull
    private PaymentTypeEnum formaPagamento;
}
