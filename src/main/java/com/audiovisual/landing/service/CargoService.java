package com.audiovisual.landing.service;

import com.audiovisual.landing.dto.CargoDto;

import java.util.List;

public interface CargoService {

    List<CargoDto> listarCargos() throws Exception;

}
