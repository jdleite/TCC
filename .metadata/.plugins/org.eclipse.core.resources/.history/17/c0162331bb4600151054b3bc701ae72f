package br.com.mercado.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "seqEntrada", sequenceName = "SEQ_ENTRADA_PROD", allocationSize = 1)
@Table(name = "TB_DI_ENTRADA_PRODUTO")
public class Entrada {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEntrada")
	@Column(name = "CD_ENTRADA")
	private int cdEntrada;
	@ManyToOne
	private Produto produto;
	@Column(name = "PRECO_COMPRA", length = 10, nullable = true)
	private double precoCompra;
	@Column(name = "QT_COMPRA", nullable = true)
	private int qtCompra;
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_VALIDADE", nullable = true)
	private Calendar dtValidade;
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_COMPRA", nullable = true)
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

}
