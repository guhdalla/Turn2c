package com.turn2c.resource;

import com.turn2c.dto.request.ConsorcioRequestDto;
import com.turn2c.dto.request.PagarConsorcioRequestDto;
import com.turn2c.dto.response.ConsorcioDto;
import com.turn2c.dto.response.ResponseDto;
import com.turn2c.service.ConsorcioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Tag(name = "Consorcio", description = "Consorcio")
public class ConsorcioResource extends ResourceAbstract {

    private final ConsorcioService service;

    @PostMapping("/consorcio")
    public ResponseDto<ConsorcioDto> create(@RequestBody ConsorcioRequestDto request) {

        return returnCreated(service.create(request));
    }

    @PostMapping("/consorcio/{id}/pagar")
    public ResponseDto<Void> pagar(@PathVariable Long id,
                                   @RequestBody PagarConsorcioRequestDto request) {

        service.pagar(id, request);
        return returnSuccess();
    }

    @GetMapping
    public ResponseDto<Page<ConsorcioDto>> find(@RequestParam(required = false) Boolean pago,
                                                @RequestParam(required = false) Long vendedorId,
                                                @RequestParam(required = false) Long clienteId,
                                                Pageable pageable) {

        return returnSuccess(service.find(pago, vendedorId, clienteId, pageable));
    }
}
