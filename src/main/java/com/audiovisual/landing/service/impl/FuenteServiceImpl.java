package com.audiovisual.landing.service.impl;

import com.audiovisual.landing.dto.FuenteDto;
import com.audiovisual.landing.model.Fuente;
import com.audiovisual.landing.repository.FuenteRepository;
import com.audiovisual.landing.service.FuenteService;
import com.audiovisual.landing.util.Constante;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuenteServiceImpl implements FuenteService {

    private static final Logger logger = LogManager.getLogger(FuenteServiceImpl.class);

    @Autowired
    private FuenteRepository cargoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<FuenteDto> listarFuentes() throws Exception {

        List<Fuente> listFuente = cargoRepository.findByEstadoOrderByIdAsc(Constante.COD_ESTADO_ACTIVO);

        logger.info("listFuente ===> " + listFuente.toString());

        List<FuenteDto> listFuenteDto = listFuente.stream().map(pais -> modelMapper.map(pais, FuenteDto.class)).collect(Collectors.toList());

        logger.info("listFuenteDto ===> " + listFuenteDto.toString());

        return listFuenteDto;

    }
}
