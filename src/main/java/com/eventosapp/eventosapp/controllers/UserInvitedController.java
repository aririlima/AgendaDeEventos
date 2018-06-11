package com.eventosapp.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.eventosapp.models.Invated;
import com.eventosapp.eventosapp.repository.UserInvatedRepository;
import com.eventosapp.eventosapp.repository.EventRepository;

//CONTROLLER GERENCIADOR DE CONVITES E USUÁRIOS CONVIDADOS

@RestController
@RequestMapping(value="/")
public class UserInvitedController {

	@Autowired
	private UserInvatedRepository cr;
	@Autowired
	private EventRepository er;
	
//	@GetMapping(value="/cadastrarConvidados")
//	public ModelAndView getCadastroPage() {
//		return new ModelAndView("evento/detalhesEvento");
//	}
	
	@PostMapping(value="evento/{codigo}")
	public ModelAndView cadastro(Invated convidado, @PathVariable("codigo") long codigo) {
		
		convidado.setEvento(er.findByCodigo(codigo));
		
		if(cr.save(convidado) != null) {
			ModelAndView mv = new ModelAndView("global/cadastroRealizado");
			return mv;
			
		}else {
			ModelAndView mv = new ModelAndView("global/cadastroNaoRealizado");
			return mv;
		}
	}
	
//	@GetMapping(value="evento/{codigo}")
//	public ModelAndView listaConvidados(@PathVariable("codigo") long codigo) {		
//		Convidado convidado = cr.findByEvento(codigo);
//		Evento evento = er.findByCodigo(codigo);
//		
//		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
//		mv.addObject("evento", evento);
//		mv.addObject("convidado", convidado.getEvento().getCodigo());
//
//		System.out.println(codigo);
//		return mv;
//	}
	
//	@PostMapping(value="cadastraConvidados")
//	public ModelAndView cadastra(Convidado convidado) {
//		er.save(convidado);
//		
//		return new ModelAndView("cadastroRealizado");
//	}
}
