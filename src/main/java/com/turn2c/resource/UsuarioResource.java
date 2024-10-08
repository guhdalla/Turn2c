package com.turn2c.resource;

import com.turn2c.dto.request.UsuarioRequestDto;
import com.turn2c.dto.response.ResponseDto;
import com.turn2c.dto.response.UsuarioDto;
import com.turn2c.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "Usuario")
public class UsuarioResource extends ResourceAbstract {

    private final UsuarioService service;

    @PostMapping("/usuario")
    public ResponseDto<UsuarioDto> create(@RequestBody @Valid UsuarioRequestDto request) {

        return returnSuccess(service.create(request));
    }

    @PutMapping("/usuario/{id}")
    public ResponseDto<UsuarioDto> update(@PathVariable Long id,
                                          @RequestBody @Valid UsuarioRequestDto request) {

        return returnSuccess(service.update(id, request));
    }

    @GetMapping("/usuario/{id}")
    public ResponseDto<UsuarioDto> findById(@PathVariable Long id) {

        return returnSuccess(service.findById(id));
    }

    @GetMapping("/usuarios")
    public ResponseDto<List<UsuarioDto>> findAll() {

        return returnSuccess(service.findAll());
    }
}
