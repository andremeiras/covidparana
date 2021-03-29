package br.com.andremeiras.covidparana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.andremeiras.covidparana.model.CasosEObitos;
import br.com.andremeiras.covidparana.repository.CasosEObitosRepository;

@Controller
public class CasosEObitosController {
 
    @Autowired
    private CasosEObitosRepository cr;

    @RequestMapping("/casoseobitos")
    public ModelAndView listarCasosEObitos() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<CasosEObitos> listaCasosEObitos = cr.findAll();
        mv.addObject("casoseobitos", listaCasosEObitos);
        return mv;
    }
}
