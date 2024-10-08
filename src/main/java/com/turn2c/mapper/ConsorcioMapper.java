package com.turn2c.mapper;

import com.turn2c.domain.Cliente;
import com.turn2c.domain.Consorcio;
import com.turn2c.domain.Vendedor;
import com.turn2c.dto.request.ConsorcioRequestDto;
import com.turn2c.dto.response.ConsorcioDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConsorcioMapper {
    default Consorcio toEntity(ConsorcioRequestDto request) {

        return Consorcio.builder()
                .valor(request.getValor())
                .pago(false)
                .cliente(Cliente.builder().id(request.getClienteId()).build())
                .vendedor(Vendedor.builder().id(request.getVendedorId()).build())
                .build();
    }

    ConsorcioDto toDto(Consorcio entity);
}
