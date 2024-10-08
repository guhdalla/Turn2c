package com.turn2c.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsorcioDto {

    private Long id;
    private ClienteDto cliente;
    private VendedorDto vendedor;
    private BigDecimal valor;
    private Boolean pago;
}
