package com.audiovisual.landing.service.impl;

import com.audiovisual.landing.dto.LeadDto;
import com.audiovisual.landing.model.Campana;
import com.audiovisual.landing.model.Lead;
import com.audiovisual.landing.repository.CampanaRepository;
import com.audiovisual.landing.repository.LeadRepository;
import com.audiovisual.landing.request.RequestRegistroLead;
import com.audiovisual.landing.service.LeadService;
import com.audiovisual.landing.service.SendinBlueService;
import com.audiovisual.landing.util.Constante;
import com.audiovisual.landing.util.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LeadServiceImpl implements LeadService {

    private static final Logger logger = LogManager.getLogger(LeadServiceImpl.class);

    @Autowired
    private CampanaRepository campanaRepository;

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private SendinBlueService sendinBlueService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LeadDto registrarLead(RequestRegistroLead requestRegistroLead) throws Exception {

        logger.info("requestRegistroLead ===> " + requestRegistroLead.toString());

        Campana campana = campanaRepository.findByIdCampanaAndEstado(StringUtil.toInteger(requestRegistroLead.getIdCampana()), Constante.COD_ESTADO_ACTIVO);

        logger.info("campana ===> " + campana.toString());

        Lead lead = new Lead();
        lead.setCorreo(requestRegistroLead.getCorreo());
        lead.setListaLead(campana.getListaLead());
        lead.setCampana(campana);

        lead.setEstado(Constante.COD_ESTADO_ACTIVO);
        lead.setFechaRegistro(Instant.now());
        lead.setUsuarioRegistro(Constante.USUARIO_DEFAULT);

        leadRepository.save(lead);

        LeadDto leadDto = modelMapper.map(lead, LeadDto.class);

        logger.info("leadDto ===> " + leadDto.toString());

        return leadDto;

    }

    @Override
    public void agregarContactoSendinBlue(RequestRegistroLead requestRegistroLead) throws Exception {

        logger.info("requestRegistroLead ===> " + requestRegistroLead.toString());

        Campana campana = campanaRepository.findByIdCampanaAndEstado(StringUtil.toInteger(requestRegistroLead.getIdCampana()), Constante.COD_ESTADO_ACTIVO);

        logger.info("campana ===> " + campana.toString());

        sendinBlueService.crearContacto(requestRegistroLead.getCorreo(), campana.getIdlistaProveedorEmailMarketing(), campana.getProveedorEmailMarketing().getApi());

    }

}
