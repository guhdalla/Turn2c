package com.turn2c.service.impl;

import com.turn2c.domain.enums.ErrorMessageEnum;
import com.turn2c.dto.request.ClienteRequestDto;
import com.turn2c.dto.response.ClienteDto;
import com.turn2c.exception.ServiceException;
import com.turn2c.mapper.ClienteMapper;
import com.turn2c.repository.ClienteRepository;
import com.turn2c.service.ClienteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteMapper mapper;
    private final ClienteRepository repository;

    @Override
    public ClienteDto create(ClienteRequestDto request) {

        var cliente = mapper.toEntity(request);
        cliente = repository.save(cliente);
        return mapper.toDto(cliente);
    }

    @Override
    public ClienteDto findById(Long id) {

        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ServiceException(ErrorMessageEnum.NOT_FOUND));
    }

    @Override
    public ClienteDto update(Long id, ClienteRequestDto request) {

        findById(id);
        var cliente = mapper.toEntity(request);
        cliente.setId(id);
        cliente = repository.save(cliente);
        return mapper.toDto(cliente);
    }

    @Override
    public List<ClienteDto> findAll() {

        return mapper.toDto(repository.findAll());
    }
}
