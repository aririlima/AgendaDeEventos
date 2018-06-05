package com.eventosapp.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.eventosapp.models.Convidado;
import com.eventosapp.eventosapp.models.Evento;
import com.eventosapp.eventosapp.repository.ConvidadoRepository;
import com.eventosapp.eventosapp.repository.EventoRepository;

@RestController
@RequestMapping(value="/convidado")
public class ConvidadosController {

	@Autowired
	private ConvidadoRepository cr;
	@Autowired
	private EventoRepository er;
	
//	@GetMapping(value="/cadastrarConvidados")
//	public ModelAndView getCadastroPage() {
//		return new ModelAndView("evento/detalhesEvento");
//	}
	
	@PostMapping(value="/{codigo}")
	public ModelAndView cadastro(Convidado convidado, @PathVariable("codigo") long codigo) {
		
		convidado.setEvento(er.findByCodigo(codigo));
		
		if(cr.save(convidado) != null) {
			ModelAndView mv = new ModelAndView("cadastroRealizado");
			return mv;
		}else {
			ModelAndView mv = new ModelAndView("cadastroNaoRealizado");
			return mv;
		}
	}
	
//	@PostMapping(value="cadastraConvidados")
//	public ModelAndView cadastra(Convidado convidado) {
//		er.save(convidado);
//		
//		return new ModelAndView("cadastroRealizado");
//	}
	
}
