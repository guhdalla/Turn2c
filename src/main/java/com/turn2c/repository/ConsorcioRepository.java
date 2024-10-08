package com.turn2c.repository;

import com.turn2c.domain.Consorcio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConsorcioRepository extends JpaRepository<Consorcio, Long>, JpaSpecificationExecutor<Consorcio> {
}
