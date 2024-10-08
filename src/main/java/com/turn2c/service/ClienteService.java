package com.turn2c.service;

import com.turn2c.dto.request.ClienteRequestDto;
import com.turn2c.dto.response.ClienteDto;
import jakarta.validation.Valid;
import java.util.List;

public interface ClienteService {
    ClienteDto create(@Valid ClienteRequestDto request);

    ClienteDto findById(Long id);

    ClienteDto update(Long id, @Valid ClienteRequestDto request);

    List<ClienteDto> findAll();
}
