package com.audiovisual.landing.service.impl;

import com.audiovisual.landing.dto.CampanaDto;
import com.audiovisual.landing.model.Campana;
import com.audiovisual.landing.repository.CampanaRepository;
import com.audiovisual.landing.util.Constante;
import com.audiovisual.landing.service.CampanaService;
import com.audiovisual.landing.util.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampanaServiceImpl implements CampanaService {

    private static final Logger logger = LogManager.getLogger(CampanaServiceImpl.class);

    @Autowired
    private CampanaRepository campanaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CampanaDto obtenerCampanaPorId(String idCampana) throws Exception {

        Campana campana = campanaRepository.findByIdCampanaAndEstado(StringUtil.toInteger(idCampana), Constante.COD_ESTADO_ACTIVO);

        logger.info("campana ===> " + campana.toString());

        CampanaDto campanaDto = modelMapper.map(campana, CampanaDto.class);

        logger.info("campanaDto ===> " + campanaDto.toString());

        return campanaDto;
    }
}
