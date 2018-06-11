package com.eventosapp.eventosapp.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

//CLASSE CONVIDADO EXISTE APENAS PARA USUÁRIOS NÃO CADASTRADOS
//AO CONVIDAR UM USUÁRIO NÃO CADASTRADO, UM E-MAIL É ENVIADO AO MESMO PARA QUE REALIZE O CADASTRO
//QUANDO CADASTRADO PASSA A SER USER

@Entity
public class Invated implements Serializable{
	
	private static final long serialVersionUID= 1L;



	@Id
	@NotNull
	private String email;
	@NotNull
	private String nomeConvidado;	
	@ManyToOne
	private Event evento;
	
	

	public String getNomeConvidado() {
		return nomeConvidado;
	}
	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}
	public Event getEvento() {
		return evento;
	}
	public void setEvento(Event evento) {
		this.evento = evento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
