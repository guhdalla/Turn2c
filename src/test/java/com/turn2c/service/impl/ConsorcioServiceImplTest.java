package com.turn2c.service.impl;

import com.turn2c.domain.Consorcio;
import com.turn2c.domain.enums.PaymentTypeEnum;
import com.turn2c.dto.request.ConsorcioRequestDto;
import com.turn2c.dto.request.PagarConsorcioRequestDto;
import com.turn2c.dto.response.ConsorcioDto;
import com.turn2c.exception.ServiceException;
import com.turn2c.factory.PaymentFactory;
import com.turn2c.mapper.ConsorcioMapper;
import com.turn2c.repository.ConsorcioRepository;
import com.turn2c.service.PaymentService;
import java.util.List;
import java.util.Optional;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsorcioServiceImplTest {

    @InjectMocks
    private ConsorcioServiceImpl service;

    @Mock
    private ConsorcioMapper mapper;

    @Mock
    private ConsorcioRepository repository;

    @Mock
    private PaymentFactory paymentFactory;

    @Mock
    private PaymentService paymentService;

    @Test
    void create_shouldOk() {

        ConsorcioRequestDto request = Instancio.create(ConsorcioRequestDto.class);
        ConsorcioDto dto = Instancio.create(ConsorcioDto.class);
        Consorcio entity = Instancio.create(Consorcio.class);

        when(mapper.toEntity(any(ConsorcioRequestDto.class))).thenReturn(entity);
        when(repository.save(any(Consorcio.class))).thenReturn(entity);
        when(mapper.toDto(any(Consorcio.class))).thenReturn(dto);

        var result = service.create(request);

        assertNotNull(result);
    }

    @Test
    void pagar_shouldOk() {

        PagarConsorcioRequestDto request = Instancio.create(PagarConsorcioRequestDto.class);
        Consorcio entity = Instancio.create(Consorcio.class);

        when(repository.findById(any(Long.class))).thenReturn(Optional.of(entity));
        when(paymentFactory.getPaymentService(any(PaymentTypeEnum.class))).thenReturn(paymentService);
        doNothing().when(paymentService).pagar(any(Long.class));
        when(repository.save(any(Consorcio.class))).thenReturn(entity);

        assertDoesNotThrow(() -> service.pagar(1L, request));
    }

    @Test
    void pagar_shouldThrow() {

        PagarConsorcioRequestDto request = Instancio.create(PagarConsorcioRequestDto.class);

        when(repository.findById(any(Long.class))).thenReturn(Optional.empty());

        assertThrows(ServiceException.class, () -> service.pagar(1L, request));
    }

    @Test
    void find_shouldOk() {

        List<Consorcio> entities = Instancio.ofList(Consorcio.class).create();

        when(repository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(new PageImpl<>(entities));
        when(mapper.toDto(any(Consorcio.class))).thenReturn(Instancio.create(ConsorcioDto.class));

        var result = service.find(true, 1L, 1L, Pageable.unpaged());

        assertNotNull(result);
    }
}