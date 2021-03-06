package br.com.mercado.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@SequenceGenerator(name = "seqCategoria", sequenceName = "SEQ_CATEGORIA", allocationSize = 1)
@Table(name = "TB_DI_CATEGORIA")
public class Categoria implements Serializable{	
	
	
	private static final long serialVersionUID = 1292760564177048211L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCategoria")
	@Column(name = "CD_CATEGORIA")
	private int cdCategoria;
	
	
	@Column(name = "TIPO", length = 20, nullable = false)
	private String tipo;
	
	
	@Column(name="DESCRICAO",length=100,nullable=false)
	private String descricao;
	
	
	@Column(name="UNIDADE",length=15,nullable=false)
	private String unidade;

	
	public Categoria() {

	}

	

	
	public String getTipo() {
		return tipo;
	}

	
	public void setTipo(String tipo) {
		this.tipo = tipo.toUpperCase();
	}

	
	public String getDescricao() {
		return descricao;
	}

	
	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
	}

	
	public String getUnidade() {
		return unidade;
	}

	
	public void setUnidade(String unidade) {
		this.unidade = unidade.toUpperCase();
	}



	
	public int getCdCategoria() {
		return cdCategoria;
	}



	
	public void setCdCategoria(int cdCategoria) {
		this.cdCategoria = cdCategoria;
	}

	
	

}
