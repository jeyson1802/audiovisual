package com.audiovisual.landing.service;

import com.audiovisual.landing.dto.ConferenciaDto;

public interface ConferenciaService {

    ConferenciaDto obtenerConferenciaPorPais(Integer idPais) throws Exception;

}
