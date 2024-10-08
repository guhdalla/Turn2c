package com.turn2c.service.impl;

import com.turn2c.domain.enums.ErrorMessageEnum;
import com.turn2c.dto.request.MasterRequestDto;
import com.turn2c.dto.response.MasterDto;
import com.turn2c.exception.ServiceException;
import com.turn2c.mapper.MasterMapper;
import com.turn2c.repository.MasterRepository;
import com.turn2c.service.MasterService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MasterServiceImpl implements MasterService {

    private final MasterMapper mapper;
    private final MasterRepository repository;

    @Override
    public MasterDto create(@Valid MasterRequestDto masterRequestDto) {

        var entity = mapper.toEntity(masterRequestDto);
        var savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    @Override
    public MasterDto update(Long id, @Valid MasterRequestDto masterRequestDto) {

        findById(id);
        var entity = mapper.toEntity(masterRequestDto);
        entity.setId(id);
        var savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    @Override
    public MasterDto findById(Long id) {

        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ServiceException(ErrorMessageEnum.NOT_FOUND));
    }

    @Override
    public List<MasterDto> findAll() {

        return mapper.toDto(repository.findAll());
    }
}
