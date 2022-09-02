package com.audiovisual.landing.service;

import com.audiovisual.landing.dto.LeadDto;
import com.audiovisual.landing.request.RequestRegistroLead;

public interface LeadService {

    LeadDto registrarLead(RequestRegistroLead requestRegistroLead) throws Exception;

    void agregarContactoSendinBlue(RequestRegistroLead requestRegistroLead) throws Exception;

}
