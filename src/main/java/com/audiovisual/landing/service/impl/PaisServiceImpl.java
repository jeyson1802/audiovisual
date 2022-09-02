package com.audiovisual.landing.service.impl;

import com.audiovisual.landing.dto.PaisDto;
import com.audiovisual.landing.repository.PaisRepository;
import com.audiovisual.landing.util.Constante;
import com.audiovisual.landing.model.Pais;
import com.audiovisual.landing.service.PaisService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisServiceImpl implements PaisService {

    private static final Logger logger = LogManager.getLogger(PaisServiceImpl.class);

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PaisDto> listarPaises() throws Exception {

        List<Pais> listPais = paisRepository.findByEstadoOrderByDescripcionAsc(Constante.COD_ESTADO_ACTIVO);

        List<PaisDto> listPaisDto = listPais.stream().map(pais -> modelMapper.map(pais, PaisDto.class)).collect(Collectors.toList());

        return listPaisDto;

    }
}
