package com.turn2c.service.impl;

import com.turn2c.domain.enums.ErrorMessageEnum;
import com.turn2c.dto.request.VendedorRequestDto;
import com.turn2c.dto.response.VendedorDto;
import com.turn2c.exception.ServiceException;
import com.turn2c.mapper.VendedorMapper;
import com.turn2c.repository.VendedorRepository;
import com.turn2c.service.VendedorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendedorServiseImpl implements VendedorService {

    private final VendedorMapper mapper;
    private final VendedorRepository repository;

    @Override
    public VendedorDto create(VendedorRequestDto request) {

        var entity = mapper.toEntity(request);
        var saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public VendedorDto findById(Long id) {

        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ServiceException(ErrorMessageEnum.NOT_FOUND));
    }

    @Override
    public VendedorDto update(Long id, VendedorRequestDto request) {

        findById(id);
        var entity = mapper.toEntity(request);
        entity.setId(id);
        var saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public List<VendedorDto> findAll() {

        return mapper.toDto(repository.findAll());
    }
}
