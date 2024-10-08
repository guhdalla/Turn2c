package com.turn2c.resource;

import com.turn2c.dto.request.MasterRequestDto;
import com.turn2c.dto.response.MasterDto;
import com.turn2c.dto.response.ResponseDto;
import com.turn2c.service.MasterService;
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
@Tag(name = "Master", description = "Master")
public class MasterResource extends ResourceAbstract {

    private final MasterService service;

    @PostMapping("/master")
    public ResponseDto<MasterDto> create(@RequestBody @Valid MasterRequestDto masterDto) {

        return returnSuccess(service.create(masterDto));
    }

    @PutMapping("/master/{id}")
    public ResponseDto<MasterDto> update(@PathVariable Long id,
                                         @RequestBody @Valid MasterRequestDto masterDto) {

        return returnSuccess(service.update(id, masterDto));
    }

    @GetMapping("/master/{id}")
    public ResponseDto<MasterDto> findById(@PathVariable Long id) {

        return returnSuccess(service.findById(id));
    }

    @GetMapping("/masters")
    public ResponseDto<List<MasterDto>> findAll() {

        return returnSuccess(service.findAll());
    }

}
