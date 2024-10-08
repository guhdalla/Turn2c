package com.turn2c.resource;

import com.turn2c.dto.request.ClienteRequestDto;
import com.turn2c.dto.response.ClienteDto;
import com.turn2c.dto.response.ResponseDto;
import com.turn2c.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Tag(name = "Cliente", description = "Cliente")
public class ClienteResource extends ResourceAbstract {

    private final ClienteService service;

    @PostMapping("/cliente")
    public ResponseDto<ClienteDto> create(@RequestBody @Valid ClienteRequestDto request) {

        return returnSuccess(service.create(request));
    }

    @GetMapping("/cliente/{id}")
    public ResponseDto<ClienteDto> findById(@PathVariable Long id) {

        return returnSuccess(service.findById(id));
    }

    @PostMapping("/cliente/{id}")
    public ResponseDto<ClienteDto> update(@PathVariable Long id,
                                          @RequestBody @Valid ClienteRequestDto request) {

        return returnSuccess(service.update(id, request));
    }

    @GetMapping("/clientes")
    public ResponseDto<List<ClienteDto>> findAll() {

        return returnSuccess(service.findAll());
    }
}
