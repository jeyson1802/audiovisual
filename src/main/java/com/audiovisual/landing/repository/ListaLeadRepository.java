package com.audiovisual.landing.repository;

import com.audiovisual.landing.model.Campana;
import com.audiovisual.landing.model.ListaLead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaLeadRepository extends JpaRepository<ListaLead, Integer> {

    ListaLead findByIdListaLeadAndEstado(Integer idListaLead, String estado) throws Exception;
}