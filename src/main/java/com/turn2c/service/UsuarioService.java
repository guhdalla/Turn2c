package com.turn2c.service;

import com.turn2c.dto.request.UsuarioRequestDto;
import com.turn2c.dto.response.UsuarioDto;
import jakarta.validation.Valid;
import java.util.List;

public interface UsuarioService {
    UsuarioDto create(@Valid UsuarioRequestDto request);

    UsuarioDto update(Long id, @Valid UsuarioRequestDto request);

    UsuarioDto findById(Long id);

    List<UsuarioDto> findAll();
}
