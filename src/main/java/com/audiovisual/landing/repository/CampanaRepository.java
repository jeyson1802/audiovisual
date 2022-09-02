package com.audiovisual.landing.repository;

import com.audiovisual.landing.model.Campana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampanaRepository extends JpaRepository<Campana, Integer> {
    Campana findByIdCampanaAndEstado(Integer idCampana, String estado) throws Exception;
}