package com.turn2c.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MasterRequestDto {

    @NotNull
    private Long usuarioId;

    private Long clienteId;

    private Long vendedorId;
}
