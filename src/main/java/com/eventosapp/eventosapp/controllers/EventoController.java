package com.eventosapp.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.eventosapp.models.Evento;
import com.eventosapp.eventosapp.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository er;
	
	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}

	@RequestMapping(value="/cadastrarEvento", method=RequestMethod.POST)
	public String formEvendo(Evento evento) {
		
		er.save(evento);
		
		return "redirect:evento/formEvento";
	}
	
	@RequestMapping(value="/listaEventos")
	public ModelAndView listaEventos() {
		Iterable<Evento> eventos = er.findAll(); 

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}")
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {		
		Evento evento = er.findByCodigo(codigo);
		
		ModelAndView mv = new ModelAndView("detalhesEvento");
		mv.addObject("evento", evento);

		return mv;
	}
	

}
