package com.audiovisual.landing.web;

import com.audiovisual.landing.service.CargoService;
import com.audiovisual.landing.service.ConferenciaService;
import com.audiovisual.landing.service.FuenteService;
import com.audiovisual.landing.service.PaisService;
import com.profetadavidowuor.cruzada.service.*;
import com.audiovisual.landing.util.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {

    @Autowired
    private PaisService paisService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private FuenteService fuenteService;

    @Autowired
    private ConferenciaService conferenciaService;


    @GetMapping("/")
    public String inicioPage(Model model) throws Exception {

        model.addAttribute("conferencia", conferenciaService.obtenerConferenciaPorPais(Constante.COD_PAIS_REPUBLICA_DOMINICANA));
        return "home";
    }

}
