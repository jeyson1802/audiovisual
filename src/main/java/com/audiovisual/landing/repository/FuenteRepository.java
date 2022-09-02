package com.audiovisual.landing.repository;

import com.audiovisual.landing.model.Fuente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FuenteRepository extends CrudRepository<Fuente, Integer> {

    List<Fuente> findByEstadoOrderByIdAsc(String estado) throws Exception;
}