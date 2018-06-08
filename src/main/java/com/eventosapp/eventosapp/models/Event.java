package com.eventosapp.eventosapp.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.eventosapp.eventosapp.enums.StatusEvent;

//EVENTOS PODEM SERM PUBLICOS OU PRIVADOS
//EVENTOS PUBLICOS EXIGEM QUE APENAS O SEU CRIADOR OU A QUEM O MESMO DER PERMIÇÃO EMITIR CONVITES
//EVENTOS PUBLICOS, QUALQUER USUÁRIO CADASTRADO NA PLATAFORMA PODE CONVIDAR OUTRAS PESSOAS OU A SI MESMO

@Entity
public class Event implements Serializable{

	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long codigo;
	
	private String nome;
	private String local;
	private Calendar data;
	private Calendar horarioInicio;
	private Calendar horarioFim;
	private StatusEvent status;

	
	public StatusEvent getStatus() {
		return status;
	}
	public void setStatus(StatusEvent status) {
		this.status = status;
	}
	@OneToMany
	private List <Invated> convidados;
	
	@ManyToOne
	private User user;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}

	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Calendar getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(Calendar horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public Calendar getHorarioFim() {
		return horarioFim;
	}
	public void setHorarioFim(Calendar horarioFim) {
		this.horarioFim = horarioFim;
	}
	public List<Invated> getConvidados() {
		return convidados;
	}
	public void setConvidados(List<Invated> convidados) {
		this.convidados = convidados;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
