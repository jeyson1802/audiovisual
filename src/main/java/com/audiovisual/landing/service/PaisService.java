package com.audiovisual.landing.service;

import com.audiovisual.landing.dto.PaisDto;

import java.util.List;

public interface PaisService {

    List<PaisDto> listarPaises() throws Exception;

}
