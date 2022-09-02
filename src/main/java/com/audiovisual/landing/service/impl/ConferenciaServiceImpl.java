package com.audiovisual.landing.service.impl;

import com.audiovisual.landing.dto.ConferenciaDto;
import com.audiovisual.landing.repository.ConferenciaRepository;
import com.audiovisual.landing.util.Constante;
import com.audiovisual.landing.model.Conferencia;
import com.audiovisual.landing.service.ConferenciaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenciaServiceImpl implements ConferenciaService {

    private static final Logger logger = LogManager.getLogger(ConferenciaServiceImpl.class);

    @Autowired
    private ConferenciaRepository conferenciaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ConferenciaDto obtenerConferenciaPorPais(Integer idPais) throws Exception {

        Conferencia conferencia = conferenciaRepository.findByPaisIdAndEstado(idPais, Constante.COD_ESTADO_ACTIVO);

        logger.info("conferencia ===> " + conferencia.toString());

        ConferenciaDto conferenciaDto = modelMapper.map(conferencia, ConferenciaDto.class);

        logger.info("conferenciaDto ===> " + conferenciaDto.toString());

        return conferenciaDto;
    }
}
