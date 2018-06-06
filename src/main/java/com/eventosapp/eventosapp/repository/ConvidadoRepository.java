package com.eventosapp.eventosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.eventosapp.models.Convidado;
import com.eventosapp.eventosapp.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
		
	Convidado findByRg(String rg);
	Iterable<Convidado> findByEvento(Evento evento);
	
}
