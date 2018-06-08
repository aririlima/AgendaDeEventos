package com.eventosapp.eventosapp.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

//O USER É USUÁRIO JÁ CADASTRADO NO SISTEMA
//É CAPAZ DE CRIAR EVENTOS, CONVIDAR OUTROS USUÁRIOS ASSIM COMO A SÍ MESMO EM EVENTOS PUBLICOS DE TERCEIROS

@Entity
public class User implements Serializable{

	private static final long serialVersionUID= 1L;

	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	@NotNull
	private String nome;
	@NotNull
	private String sobrenome;
	@NotNull
	private String cpf;
	private Calendar nascimento;
	private String endereco;
	private String telefone;
	@NotNull //O email é o login
	private String email;
	private String senha;
	
	@OneToMany
	@Column(table="meus eventos")
	private List <Event> myEvents;
	
	@OneToMany
	@Column(table="eventos convidados")
	private List <Event> myEventsParticipate;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Event> getMyEvents() {
		return myEvents;
	}
	public void setMyEvents(List<Event> myEvents) {
		this.myEvents = myEvents;
	}
	public List<Event> getMyEventsParticipate() {
		return myEventsParticipate;
	}
	public void setMyEventsParticipate(List<Event> myEventsParticipate) {
		this.myEventsParticipate = myEventsParticipate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
