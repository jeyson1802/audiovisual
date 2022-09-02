package com.audiovisual.landing.repository;

import com.audiovisual.landing.model.Cargo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CargoRepository extends CrudRepository<Cargo, Integer> {

    List<Cargo> findByEstadoOrderByIdAsc(String estado) throws Exception;
}