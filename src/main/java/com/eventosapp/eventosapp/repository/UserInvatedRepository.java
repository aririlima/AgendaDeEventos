package com.eventosapp.eventosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.eventosapp.models.Invated;
import com.eventosapp.eventosapp.models.Event;

//REPOSITÓRIO DE USUÁRIOS CADASTRADOS AO SISTEMA CONVIDADOS
public interface UserInvatedRepository extends CrudRepository<Invated, String>{
		
	Invated findByEmail(String email);
	Iterable<Invated> findByEvento(Event evento);
	
}
