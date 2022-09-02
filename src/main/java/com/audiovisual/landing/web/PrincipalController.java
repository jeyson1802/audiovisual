package com.audiovisual.landing.web;

import com.audiovisual.landing.service.CampanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PrincipalController {

    @Autowired
    private CampanaService campanaService;


    @GetMapping("/regalo/{idCampana}")
    public String inicioPage(Model model, @PathVariable String idCampana) throws Exception {

        model.addAttribute("campana", campanaService.obtenerCampanaPorId(idCampana));
        return "landing";
    }

}
