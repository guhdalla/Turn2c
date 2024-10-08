package com.turn2c.mapper;

import com.turn2c.domain.Cliente;
import com.turn2c.dto.request.ClienteRequestDto;
import com.turn2c.dto.response.ClienteDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClienteMapper {

    @Mapping(source = "usuarioId", target = "usuario.id")
    Cliente toEntity(ClienteRequestDto request);

    ClienteDto toDto(Cliente cliente);

    List<ClienteDto> toDto(List<Cliente> list);
}
