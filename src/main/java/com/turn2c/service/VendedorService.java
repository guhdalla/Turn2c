package com.turn2c.service;

import com.turn2c.dto.request.VendedorRequestDto;
import com.turn2c.dto.response.VendedorDto;
import jakarta.validation.Valid;
import java.util.List;

public interface VendedorService {
    VendedorDto create(@Valid VendedorRequestDto request);

    VendedorDto findById(Long id);

    VendedorDto update(Long id, @Valid VendedorRequestDto request);

    List<VendedorDto> findAll();
}
