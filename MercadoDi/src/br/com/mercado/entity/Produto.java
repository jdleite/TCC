package br.com.mercado.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seqProduto", sequenceName = "SEQ_PRODUTO", allocationSize = 1)
@Table(name = "TB_DI_PRODUTO")
public class Produto implements Serializable{
	private static final long serialVersionUID = -751802412374699261L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduto")
	@Column(name = "CD_PRODUTO")
	private int cdProduto;
	@ManyToOne
	@JoinColumn(name = "CD_CATEGORIA")
	private Categoria categoria;
	@ManyToOne
	@JoinColumn(name = "CD_FORNECEDOR")
	private Fornecedor fornecedor;
    @OneToMany(mappedBy="produto")
	private List<Entrada> entrada;
	@Column(name = "CD_BARRA", length = 10, nullable = true)
	private int cdBarra;
	@Column(name = "NM_PRODUTO", length = 50, nullable = true)
	private String nmProduto;
	@Column(name = "DESCRICAO", length = 100, nullable = true)
	private String descricao;
	@Column(name = "PESO", length = 10, nullable = true)
	private String peso;
	@Column(name = "ESTOQUE", length = 10, nullable = true)
	private int estoque;

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

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public List<Entrada> getEntrada() {
		return entrada;
	}

	public void setEntrada(List<Entrada> entrada) {
		this.entrada = entrada;
	}

	

	
}
