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
public class ClienteDto {

    private Long id;

    @Valid
    private UsuarioDto usuario;
}
