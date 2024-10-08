package com.turn2c.mapper;

import com.turn2c.domain.Usuario;
import com.turn2c.dto.request.UsuarioRequestDto;
import com.turn2c.dto.response.UsuarioDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {
    Usuario toEntity(UsuarioRequestDto request);

    UsuarioDto toDto(Usuario entity);

    List<UsuarioDto> toDto(List<Usuario> list);
}
