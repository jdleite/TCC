package br.com.mercado.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@SequenceGenerator(name = "seqEntrada", sequenceName = "SEQ_ENTRADA_PROD", allocationSize = 1)
@Table(name = "TB_DI_ENTRADA_PRODUTO")
public class Entrada implements Serializable {	
	
	private static final long serialVersionUID = 7447480587752748366L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEntrada")
	@Column(name = "CD_ENTRADA")
	private int cdEntrada;
	
	
	@OneToOne
	@JoinColumn(name = "CD_Produto")
	private Produto produto;
	
	@Column(name = "PRECO_COMPRA", length = 10, nullable = false)
	private double precoCompra;
	
	
	@Column(name = "PRECO_VENDA", length = 10, nullable = false)
	private double precoVenda;
	
	
	@Column(name = "QT_COMPRA", nullable = false)
	private int qtCompra;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_VALIDADE", nullable = false)
	private Calendar dtValidade;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_COMPRA", nullable = false)
	private Calendar dtCompra;

	
	public Entrada() {

	}

	

	public int getCdEntrada() {
		return cdEntrada;
	}

	
	public void setCdEntrada(int cdEntrada) {
		this.cdEntrada = cdEntrada;
	}

	
	public double getPrecoCompra() {
		return precoCompra;
	}

	
	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}

	
	public int getQtCompra() {
		return qtCompra;
	}

	
	public void setQtCompra(int qtCompra) {
		this.qtCompra = qtCompra;
	}

	
	public Calendar getDtValidade() {
		return dtValidade;
	}

	
	public void setDtValidade(Calendar dtValidade) {
		this.dtValidade = dtValidade;
	}

	
	public Calendar getDtCompra() {
		return dtCompra;
	}

	
	public void setDtCompra(Calendar dtCompra) {
		this.dtCompra = dtCompra;
	}






	
	public Produto getProduto() {
		return produto;
	}







	public void setProduto(Produto produto) {
		this.produto = produto;
	}






	public double getPrecoVenda() {
		return precoVenda;
	}






	
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}




}
