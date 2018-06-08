package com.eventosapp.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventosapp.eventosapp.repository.EventRepository;

//CONTROLLER GERENCIADOR DE EVENTOS CRIADOS PELO USUÁRIO

@RestController
@RequestMapping(value="/")
public class UserEventsOwnerController {

	@Autowired
	private EventRepository er;
}
