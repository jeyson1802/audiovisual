package com.audiovisual.landing.repository;

import com.audiovisual.landing.model.RegistroConferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroConferenciaRepository extends JpaRepository<RegistroConferencia, Integer> {

    RegistroConferencia findByCorreo(String correo) throws Exception;
}