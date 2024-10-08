package com.turn2c.service;

import com.turn2c.dto.request.ConsorcioRequestDto;
import com.turn2c.dto.request.PagarConsorcioRequestDto;
import com.turn2c.dto.response.ConsorcioDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConsorcioService {
    ConsorcioDto create(ConsorcioRequestDto request);

    void pagar(Long id, PagarConsorcioRequestDto request);

    Page<ConsorcioDto> find(Boolean pago, Long vendedorId, Long clienteId, Pageable pageable);
}
