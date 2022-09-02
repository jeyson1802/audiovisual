package com.audiovisual.landing.repository;

import com.audiovisual.landing.model.Pais;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaisRepository extends CrudRepository<Pais, Integer> {

    List<Pais> findByEstadoOrderByDescripcionAsc(String estado) throws Exception;

    Pais findByCode(String code) throws Exception;
}