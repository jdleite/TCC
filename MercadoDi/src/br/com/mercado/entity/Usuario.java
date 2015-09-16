package br.com.mercado.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@SequenceGenerator(name = "seqUsuario", sequenceName = "SEQ_USUARIO", allocationSize = 1)
@Table(name = "TB_DI_USUARIO")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsuario")
	@Column(name = "ID")
	private int id;
	@Column(name = "LOGIN", nullable = true)
	private String nomeUsuario;
	@Column(name = "SENHA", nullable = true)
	private String senha;
	@Column(name = "ULTIMO_ACESSO",nullable = true)
	@Temporal(TemporalType.DATE)
	private Calendar ultimoAcesso ;
	@Column(name = "CARGO", nullable = true)
	private String cargo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Calendar getUltimoAcesso() {
		return ultimoAcesso;
	}
	public void setUltimoAcesso(Calendar ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
  


	
    

}
