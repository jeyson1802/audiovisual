package com.audiovisual.landing.rest;

import com.audiovisual.landing.dto.LeadDto;
import com.audiovisual.landing.request.RequestRegistroLead;
import com.audiovisual.landing.service.LeadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class AudioVisualRestController {

    private static final Logger logger = LogManager.getLogger(AudioVisualRestController.class);

    @Autowired
    private LeadService leadService;

    @PostMapping(value="/registrarLead")
    public ResponseEntity<LeadDto> registrarLead(@RequestBody RequestRegistroLead requestRegistroLead,
                                                                             WebRequest request) throws Exception {

        logger.info("Inicio registrarLead.......");

        logger.info("requestRegistroLead ==> " + requestRegistroLead);

        LeadDto leadDto = leadService.registrarLead(requestRegistroLead);

        logger.info("leadDto ==> " + leadDto);

        logger.info("Fin registrarLead.......");

        return new ResponseEntity<>(leadDto, HttpStatus.OK);
    }

    @PostMapping (value="/agregarLeadEmailMarketing")
    public void agregarLeadEmailMarketing(@RequestBody RequestRegistroLead requestRegistroLead,
                                                      WebRequest request) throws Exception {

        logger.info("Inicio agregarLeadEmailMarketing.......");

        logger.info("requestRegistroLead ==> " + requestRegistroLead);

        leadService.agregarContactoSendinBlue(requestRegistroLead);

        logger.info("Fin agregarLeadEmailMarketing.......");

    }
}
