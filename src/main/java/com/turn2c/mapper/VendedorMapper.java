package com.turn2c.mapper;

import com.turn2c.domain.Vendedor;
import com.turn2c.dto.request.VendedorRequestDto;
import com.turn2c.dto.response.VendedorDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface VendedorMapper {

    @Mapping(source = "usuarioId", target = "usuario.id")
    Vendedor toEntity(VendedorRequestDto request);

    VendedorDto toDto(Vendedor entity);

    List<VendedorDto> toDto(List<Vendedor> list);
}
