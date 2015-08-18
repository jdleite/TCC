package br.com.mercado.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seqProduto", sequenceName = "SEQ_PRODUTO", allocationSize = 1)
@Table(name = "TB_DI_PRODUTO")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduto")
	@Column(name = "CD_PRODUTO")
	private int cdProduto;
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	private Categoria categoria;
	@Column(name = "CD_FORNECEDOR", length = 10, nullable = true)
	private int fornecedor;
	@Column(name = "CD_BARRA", length = 10, nullable = true)
	private int cdBarra;
	@Column(name = "NM_PRODUTO", length = 50, nullable = true)
	private String nmProduto;
	@Column(name = "DESCRICAO", length = 100, nullable = true)
	private String descricao;
	@Column(name = "PESO", length = 5, nullable = true)
	private String peso;

	public Produto() {

	}

	public int getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(int cdProduto) {
		this.cdProduto = cdProduto;
	}

	

	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getCdBarra() {
		return cdBarra;
	}

	public void setCdBarra(int cdBarra) {
		this.cdBarra = cdBarra;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public int getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(int fornecedor) {
		this.fornecedor = fornecedor;
	}

	

}
