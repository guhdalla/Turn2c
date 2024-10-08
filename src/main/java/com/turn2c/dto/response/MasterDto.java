package com.turn2c.dto.response;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MasterDto {

    private Long id;

    @Valid
    private UsuarioDto usuario;

    @Valid
    private ClienteDto cliente;

    @Valid
    private VendedorDto vendedor;
}
