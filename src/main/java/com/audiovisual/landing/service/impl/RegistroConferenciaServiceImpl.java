package com.audiovisual.landing.service.impl;

import com.audiovisual.landing.dto.RegistroConferenciaDto;
import com.audiovisual.landing.enums.EnumErrores;
import com.audiovisual.landing.repository.ConferenciaRepository;
import com.audiovisual.landing.repository.PaisRepository;
import com.audiovisual.landing.repository.RegistroConferenciaRepository;
import com.audiovisual.landing.util.Constante;
import com.audiovisual.landing.util.StringUtil;
import com.audiovisual.landing.exception.UnprocessableEntityException;
import com.audiovisual.landing.model.Conferencia;
import com.audiovisual.landing.model.Pais;
import com.audiovisual.landing.model.RegistroConferencia;
import com.audiovisual.landing.request.RequestRegistroConferencia;
import com.audiovisual.landing.service.RegistroConferenciaService;
import com.audiovisual.landing.service.SendinBlueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class RegistroConferenciaServiceImpl implements RegistroConferenciaService {

    private static final Logger logger = LogManager.getLogger(RegistroConferenciaServiceImpl.class);

    @Autowired
    private RegistroConferenciaRepository registroConferenciaRepository;

    @Autowired
    private ConferenciaRepository conferenciaRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private SendinBlueService sendinBlueService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RegistroConferenciaDto registrarParticipanteConferencia(RequestRegistroConferencia requestRegistroConferencia) throws Exception {

        logger.info("conferencia ===> " + requestRegistroConferencia.toString());

        RegistroConferencia registroConferenciaBD = registroConferenciaRepository.findByCorreo(requestRegistroConferencia.getCorreo());

        if(!StringUtil.isEmpty(registroConferenciaBD)) {

            throw new UnprocessableEntityException(EnumErrores.ERROR_422001.getCodigo(),
                    EnumErrores.getMensaje(EnumErrores.ERROR_422001.getCodigo()));
        }

        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        RegistroConferencia registroConferencia = modelMapper.map(requestRegistroConferencia, RegistroConferencia.class);

        if(requestRegistroConferencia.getSuscripcion()) {
            registroConferencia.setIndicadorNewsletter(Constante.COD_ESTADO_ACTIVO);
        } else {
            registroConferencia.setIndicadorNewsletter(Constante.COD_ESTADO_INACTIVO);
        }

        Pais pais = paisRepository.findByCode(requestRegistroConferencia.getCodePais());
        registroConferencia.setPais(pais);

        registroConferencia.setIndicadorConstancia(Constante.INDICADOR_NO_TERMINADO);
        registroConferencia.setIndicadorCorreo(Constante.INDICADOR_NO_TERMINADO);
        registroConferencia.setIndicadorEmailMarketing(Constante.INDICADOR_NO_TERMINADO);
        registroConferencia.setEstado(Constante.COD_ESTADO_ACTIVO);
        registroConferencia.setFechaRegistro(Instant.now());
        registroConferencia.setUsuarioRegistro(Constante.USUARIO_DEFAULT);

        RegistroConferencia participante = registroConferenciaRepository.save(registroConferencia);

        logger.info("resultado ===> " + participante.toString());

        Conferencia conferencia = conferenciaRepository.findById(participante.getConferencia().getId()).get();
        participante.setConferencia(conferencia);

        RegistroConferenciaDto registroConferenciaDto = modelMapper.map(participante, RegistroConferenciaDto.class);

        logger.info("registroConferenciaDto ===> " + registroConferenciaDto.toString());

        return registroConferenciaDto;

    }

    @Override
    public void agregarContactoParticipanteSendinBlue(Integer idParticipante) throws Exception {

        RegistroConferencia participante = registroConferenciaRepository.findById(idParticipante).get();

        logger.info("agregarContactoParticipanteSendinBlue ==> INDICADOR NEWSLETTER ==> " + participante.getIndicadorNewsletter());

        if(Constante.COD_ESTADO_ACTIVO.equals(participante.getIndicadorNewsletter())) {

            Conferencia conferencia = conferenciaRepository.findById(participante.getConferencia().getId()).get();

            sendinBlueService.crearContacto(participante.getCorreo(),
                    participante.getApellidos(), participante.getNombres(),
                    participante.getCelular(), conferencia.getIdEmailMarketing(), conferencia.getApiKeyEmailMarketing());

            participante.setIndicadorEmailMarketing(Constante.INDICADOR_TERMINADO);
            registroConferenciaRepository.save(participante);
        }

    }

}
