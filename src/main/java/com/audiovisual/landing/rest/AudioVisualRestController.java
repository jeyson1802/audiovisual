package com.audiovisual.landing.rest;

import com.audiovisual.landing.dto.RegistroConferenciaDto;
import com.audiovisual.landing.request.RequestRegistroConferencia;
import com.audiovisual.landing.service.RegistroConferenciaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
public class AudioVisualRestController {

    private static final Logger logger = LogManager.getLogger(AudioVisualRestController.class);

    @Autowired
    private RegistroConferenciaService registroConferenciaService;

    @PostMapping(value="/registrarParticipanteConferencia")
    public ResponseEntity<RegistroConferenciaDto> registrarParticipanteConferencia(@RequestBody RequestRegistroConferencia requestRegistroConferencia,
                                                                            WebRequest request) throws Exception {

        logger.info("Inicio registrarParticipanteConferencia.......");

        logger.info("requestRegistroConferencia ==> " + requestRegistroConferencia);

        RegistroConferenciaDto registroConferenciaDto = registroConferenciaService.registrarParticipanteConferencia(requestRegistroConferencia);

        logger.info("registroConferenciaDto ==> " + registroConferenciaDto);

        logger.info("Fin registrarParticipanteConferencia.......");

        return new ResponseEntity<>(registroConferenciaDto, HttpStatus.OK);
    }

    @PostMapping (value="/agregarContactoParticipanteSendinBlue/{idParticipante}")
    public void agregarContactoParticipanteSendinBlue(@PathVariable("idParticipante") Integer idParticipante) throws Exception {

        logger.info("Inicio agregarContactoParticipanteSendinBlue.......");

        registroConferenciaService.agregarContactoParticipanteSendinBlue(idParticipante);

        logger.info("Fin agregarContactoParticipanteSendinBlue.......");

    }
}
