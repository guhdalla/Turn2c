package com.turn2c.service;

import com.turn2c.dto.request.MasterRequestDto;
import com.turn2c.dto.response.MasterDto;
import jakarta.validation.Valid;
import java.util.List;

public interface MasterService {
    MasterDto create(@Valid MasterRequestDto masterRequestDto);

    MasterDto update(Long id, @Valid MasterRequestDto masterRequestDto);

    MasterDto findById(Long id);

    List<MasterDto> findAll();
}
