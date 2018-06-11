package com.eventosapp.eventosapp.models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//O USER É USUÁRIO JÁ CADASTRADO NO SISTEMA
//É CAPAZ DE CRIAR EVENTOS, CONVIDAR OUTROS USUÁRIOS ASSIM COMO A SÍ MESMO EM EVENTOS PUBLICOS DE TERCEIROS

@Entity
public class User implements Serializable, UserDetails{

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
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar nascimento;
	@NotNull
	private String endereco;
	private String cep;
	private String telefone;
	@NotNull //O email é o login
	private String email;
	@NotNull
	private String senha;
	
	@ManyToMany 
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(
			name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
			name = "role_id", referencedColumnName = "roleId"))
	private List <Role> userRoles;
	
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
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public List<Role> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
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
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.userRoles;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
