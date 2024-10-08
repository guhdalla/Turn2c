package com.turn2c.mapper;

import com.turn2c.domain.Cliente;
import com.turn2c.domain.Master;
import com.turn2c.domain.Usuario;
import com.turn2c.domain.Vendedor;
import com.turn2c.dto.request.MasterRequestDto;
import com.turn2c.dto.response.MasterDto;
import java.util.List;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface MasterMapper {

    default Master toEntity(MasterRequestDto dto) {

        Master entity = new Master();
        Optional.ofNullable(dto.getVendedorId()).ifPresent(v -> entity.setVendedor(Vendedor.builder()
                .id(v)
                .build()));
        Optional.ofNullable(dto.getClienteId()).ifPresent(v -> entity.setCliente(Cliente.builder()
                .id(v)
                .build()));
        entity.setUsuario(Usuario.builder()
                .id(dto.getUsuarioId())
                .build());

        return entity;
    }

    ;

    MasterDto toDto(Master entity);

    List<MasterDto> toDto(List<Master> list);
}
