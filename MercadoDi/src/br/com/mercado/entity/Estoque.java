package br.com.mercado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seqEstoque", sequenceName = "SEQ_ESTOQUE", allocationSize = 1)
@Table(name = "TB_DI_ESTOQUE")
public class Estoque {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEstoque")
	@Column(name = "CD_ESTOQUE")
	private int cdEstoque;
	@Column(name = "QUANTIDADE", length = 10, nullable = true)
	private int quantidade;
	@ManyToOne
	private Produto produto;

	public Estoque() {

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto poduto) {
		this.produto = poduto;
	}

	public int getCdEstoque() {
		return cdEstoque;
	}

	public void setCdEstoque(int cdEstoque) {
		this.cdEstoque = cdEstoque;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
