package com.turn2c.resource;

import com.turn2c.dto.request.VendedorRequestDto;
import com.turn2c.dto.response.ResponseDto;
import com.turn2c.dto.response.VendedorDto;
import com.turn2c.service.VendedorService;
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
@Tag(name = "Vendedor", description = "Vendedor")
public class VendedorResource extends ResourceAbstract {

    private final VendedorService service;

    @PostMapping("/vendedor")
    public ResponseDto<VendedorDto> create(@RequestBody @Valid VendedorRequestDto request) {

        return returnSuccess(service.create(request));
    }

    @GetMapping("/vendedor/{id}")
    public ResponseDto<VendedorDto> findById(@PathVariable Long id) {

        return returnSuccess(service.findById(id));
    }

    @PutMapping("/vendedor/{id}")
    public ResponseDto<VendedorDto> update(@PathVariable Long id,
                                           @RequestBody @Valid VendedorRequestDto request) {

        return returnSuccess(service.update(id, request));
    }

    @GetMapping("/vendedores")
    public ResponseDto<List<VendedorDto>> findAll() {

        return returnSuccess(service.findAll());
    }
}
