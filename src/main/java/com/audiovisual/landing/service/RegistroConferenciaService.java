package com.audiovisual.landing.service;

import com.audiovisual.landing.dto.RegistroConferenciaDto;
import com.audiovisual.landing.request.RequestRegistroConferencia;

public interface RegistroConferenciaService {

    RegistroConferenciaDto registrarParticipanteConferencia(RequestRegistroConferencia requestRegistroConferencia) throws Exception;

    void agregarContactoParticipanteSendinBlue(Integer idParticipante) throws Exception;

}
