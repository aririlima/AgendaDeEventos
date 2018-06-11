package com.eventosapp.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.eventosapp.enums.StatusEvent;
import com.eventosapp.eventosapp.models.Event;
import com.eventosapp.eventosapp.models.Invated;
import com.eventosapp.eventosapp.repository.EventRepository;
import com.eventosapp.eventosapp.repository.UserInvatedRepository;

//CONTROLLER GERENCIADOR DE EVENTOS

@RestController
@RequestMapping(value="/")
public class EventController {

	
	@Autowired
	private EventRepository er;
	@Autowired
	private UserInvatedRepository cr;
	
	@GetMapping(value="cadastroEvento")
	public ModelAndView getCadastroPage() {
		return new ModelAndView("evento/cadastroEvento");
	}
	
	@GetMapping(value="home")
	public ModelAndView getHome() {
		return new ModelAndView("global/home");
	}

	
	@PostMapping(value="cadastroEvento")
	public ModelAndView cadastro(Event evento, StatusEvent se) {
		System.out.println(se);
		evento.setStatus(se);
		if(er.save(evento) != null) {
			ModelAndView mv = new ModelAndView("global/cadastroRealizado");
			return mv;
		}else {
			ModelAndView mv = new ModelAndView("global/cadastroNaoRealizado");
			return mv;
		}
	}
	
	
	
	@GetMapping(value="listaEventos") //oq vem na URL
	public ModelAndView listaEventos() {
		Iterable<Event> eventos = er.findAll(); 

		ModelAndView mv = new ModelAndView("evento/listaEventos"); //página html que é exibida
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	
	
	@GetMapping(value="evento/{codigo}")
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {		
		Event evento = er.findByCodigo(codigo);
		Iterable<Invated> convidados = cr.findByEvento(evento);

		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		mv.addObject("evento", evento);
		mv.addObject("convidado", convidados);

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
