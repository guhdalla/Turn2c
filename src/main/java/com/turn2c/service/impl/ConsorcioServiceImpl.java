package com.turn2c.service.impl;

import com.turn2c.domain.Consorcio;
import com.turn2c.domain.enums.ErrorMessageEnum;
import com.turn2c.dto.request.ConsorcioRequestDto;
import com.turn2c.dto.request.PagarConsorcioRequestDto;
import com.turn2c.dto.response.ConsorcioDto;
import com.turn2c.exception.ServiceException;
import com.turn2c.factory.PaymentFactory;
import com.turn2c.mapper.ConsorcioMapper;
import com.turn2c.repository.ConsorcioRepository;
import com.turn2c.service.ConsorcioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsorcioServiceImpl implements ConsorcioService {

    private final ConsorcioMapper mapper;
    private final ConsorcioRepository repository;
    private final PaymentFactory paymentFactory;

    @Override
    public ConsorcioDto create(ConsorcioRequestDto request) {

        var entity = mapper.toEntity(request);
        var savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    @Override
    public void pagar(Long id, PagarConsorcioRequestDto request) {

        var entity = repository.findById(id)
                .orElseThrow(() -> new ServiceException(ErrorMessageEnum.NOT_FOUND));

        var paymentService = paymentFactory.getPaymentService(request.getFormaPagamento());
        paymentService.pagar(id);

        entity.setPago(true);
        repository.save(entity);
    }

    @Override
    public Page<ConsorcioDto> find(Boolean pago, Long vendedorId, Long clienteId, Pageable pageable) {


        var specification = Specification.where(isPago(pago))
                .and(hasVendedor(vendedorId))
                .and(hasCliente(clienteId));

        var entities = repository.findAll(specification, pageable);
        return entities.map(mapper::toDto);
    }

    public static Specification<Consorcio> isPago(Boolean pago) {
        return (root, query, criteriaBuilder) ->
                pago == null ? null : criteriaBuilder.equal(root.get("pago"), pago);
    }

    public static Specification<Consorcio> hasVendedor(Long vendedorId) {
        return (root, query, criteriaBuilder) ->
                vendedorId == null ? null : criteriaBuilder.equal(root.get("vendedor").get("id"), vendedorId);
    }

    public static Specification<Consorcio> hasCliente(Long clienteId) {
        return (root, query, criteriaBuilder) ->
                clienteId == null ? null : criteriaBuilder.equal(root.get("cliente").get("id"), clienteId);
    }
}
