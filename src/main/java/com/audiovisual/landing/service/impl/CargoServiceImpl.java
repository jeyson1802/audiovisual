package com.audiovisual.landing.service.impl;

import com.audiovisual.landing.dto.CargoDto;
import com.audiovisual.landing.util.Constante;
import com.audiovisual.landing.model.Cargo;
import com.audiovisual.landing.repository.CargoRepository;
import com.audiovisual.landing.service.CargoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargoServiceImpl implements CargoService {

    private static final Logger logger = LogManager.getLogger(CargoServiceImpl.class);

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CargoDto> listarCargos() throws Exception {

        List<Cargo> listCargo = cargoRepository.findByEstadoOrderByIdAsc(Constante.COD_ESTADO_ACTIVO);

        List<CargoDto> listCargoDto = listCargo.stream().map(pais -> modelMapper.map(pais, CargoDto.class)).collect(Collectors.toList());

        return listCargoDto;

    }
}
