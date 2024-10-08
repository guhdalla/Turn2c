package com.turn2c.service.impl;

import com.turn2c.domain.enums.ErrorMessageEnum;
import com.turn2c.dto.request.UsuarioRequestDto;
import com.turn2c.dto.response.UsuarioDto;
import com.turn2c.exception.ServiceException;
import com.turn2c.mapper.UsuarioMapper;
import com.turn2c.repository.UsuarioRepository;
import com.turn2c.service.UsuarioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper mapper;
    private final UsuarioRepository repository;

    @Override
    public UsuarioDto create(UsuarioRequestDto request) {

        var entity = mapper.toEntity(request);
        var usuario = repository.save(entity);
        return mapper.toDto(usuario);
    }

    @Override
    public UsuarioDto update(Long id, UsuarioRequestDto request) {

        findById(id);
        var entity = mapper.toEntity(request);
        entity.setId(id);
        var usuario = repository.save(entity);
        return mapper.toDto(usuario);
    }

    @Override
    public UsuarioDto findById(Long id) {

        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ServiceException(ErrorMessageEnum.NOT_FOUND));
    }

    @Override
    public List<UsuarioDto> findAll() {

        return mapper.toDto(repository.findAll());
    }
}
