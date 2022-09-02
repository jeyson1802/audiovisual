package com.audiovisual.landing.service;

import com.audiovisual.landing.dto.FuenteDto;

import java.util.List;

public interface FuenteService {

    List<FuenteDto> listarFuentes() throws Exception;

}
