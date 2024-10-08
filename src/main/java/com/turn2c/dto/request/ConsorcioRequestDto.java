package com.turn2c.dto.request;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsorcioRequestDto {

    @NotNull
    private BigDecimal valor;

    @NotNull
    private Long clienteId;

    @NotNull
    private Long vendedorId;
}
