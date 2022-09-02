package com.audiovisual.landing.repository;

import com.audiovisual.landing.model.Conferencia;
import org.springframework.data.repository.CrudRepository;

public interface ConferenciaRepository extends CrudRepository<Conferencia, Integer> {

    Conferencia findByPaisIdAndEstado(Integer idPais, String estado) throws Exception;
}