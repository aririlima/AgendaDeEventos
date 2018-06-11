package com.eventosapp.eventosapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eventosapp.eventosapp.repository.UserRepository;

@RestController
@RequestMapping(value="/")
public class RoleController {

	@Autowired
	private UserRepository ur;
	
	
	@GetMapping(value="admin/roleManager")
	public ModelAndView roleMAnager() {
		return new ModelAndView("global/roleManager");
	}
}
