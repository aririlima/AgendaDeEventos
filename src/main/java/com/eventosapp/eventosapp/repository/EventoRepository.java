package com.eventosapp.eventosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.eventosapp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{
	
	public Evento findByCodigo(long codigo);
	
	
}
