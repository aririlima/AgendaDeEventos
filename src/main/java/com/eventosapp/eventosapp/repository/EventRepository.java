package com.eventosapp.eventosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.eventosapp.models.Event;

//REPOSITÓRIO DE GERENCIAMENTO DE EVENTOS
public interface EventRepository extends CrudRepository<Event, String>{
	
	Event findByCodigo(long codigo);
	
	//Returns the number of entities available.
		long count();
		
		//	Deletes a given entity.
		void delete(Event entity);
		
		//	Deletes all entities managed by the repository.
		void deleteAll();
		
		//	Deletes the given entities.
		void deleteAll(Iterable<? extends Event> entities);

		//	Deletes the entity with the given id.
		void deleteByCodigo(long codigo);
		
		//	Returns whether an entity with the given id exists.
		boolean	existsByCodigo(long codigo);
		
		//	Returns all instances of the type.
		Iterable<Event> findAll();
	
}
