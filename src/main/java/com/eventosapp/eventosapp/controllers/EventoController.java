package com.eventosapp.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.eventosapp.models.Evento;
import com.eventosapp.eventosapp.repository.EventoRepository;

@RestController
@RequestMapping(value="/")
public class EventoController {

	
	@Autowired
	private EventoRepository er;
	
	
	@GetMapping(value="/cadastrarEvento")
	public ModelAndView getCadastroPage() {
		return new ModelAndView("formEvento");
	}

	
	@PostMapping(value="cadastrarEvento")
	public ModelAndView cadastro(Evento evento) {
		if(er.save(evento) != null) {
			ModelAndView mv = new ModelAndView("/cadastroRealizado");
			return mv;
		}else {
			ModelAndView mv = new ModelAndView("/cadastroNaoRealizado");
			return mv;
		}
	}
	
	
	@GetMapping(value="listaEventos") //oq vem na URL
	public ModelAndView listaEventos() {
		Iterable<Evento> eventos = er.findAll(); 

		ModelAndView mv = new ModelAndView("listaEventos"); //página html que é exibida
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	
	@GetMapping(value="{codigo}")
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {		
		Evento evento = er.findByCodigo(codigo);
		
		ModelAndView mv = new ModelAndView("detalhesEvento");
		mv.addObject("evento", evento.getCodigo());

		System.out.println(codigo);
		return mv;
	}


	
//	@PostMapping(value="/cadastrarEventos")
//	public ResponseEntity <Response<EventoDto>> cadastro(@RequestBody EventoDto eventoDto){
//		Response<EventoDto> response = new Response<EventoDto>();
//
//		//logica
//		
//		response.setData(eventoDto);
//		
//		return null;
//	}
}
