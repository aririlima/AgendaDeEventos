package com.eventosapp.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.eventosapp.models.User;
import com.eventosapp.eventosapp.repository.UserRepository;

//CONTROLLER RESPONSÁVEL PELO LOGIN, LOGOUT E CADASTRO DE UCUÁRIOS NO SISTEMA

@RestController
@RequestMapping(value="/")
public class AcessController {

	@Autowired
	private UserRepository ur;
	
	@GetMapping(value="login")
	public ModelAndView getLogin() {
				
		return new ModelAndView("login");

	}
	
	@PutMapping(value="login")
	public ModelAndView doLogin(@PathVariable("login") String login, @PathVariable("senha") String senha) {
		
		User user = ur.findByEmail(login);
		
		if(user != null && user.getSenha() == senha) {
			return new ModelAndView("evento/home");
		}else {
			return null;
		}
	}
}

