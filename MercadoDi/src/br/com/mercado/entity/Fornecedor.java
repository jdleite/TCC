package br.com.mercado.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seqFornecedor",sequenceName="SEQ_FORNECEDOR",allocationSize=1)
@Table(name="TB_DI_FORNECEDOR")
public class Fornecedor {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="seqFornecedor")
	@Column(name="CD_FORNECEDOR")
	private int cdFornecedor;
	@Column(name="NOME",length=50,nullable=true)
	private String nome;
	@Column(name="ENDERECO",length=100,nullable=true)
	private String endereco;
	@Column(name="TELEFONE",length=20,nullable=true)
	private String telefone;
	@Column(name="CEP",length=30,nullable=true)
	private String cep;
	@Column(name="NUMERO",length=10,nullable=true)
	private String numero;
	@Column(name="BAIRRO",length=20,nullable=true)
	private String bairro;
	
	public Fornecedor(){
		
	}

	public int getCdFornecedor() {
		return cdFornecedor;
	}

	public void setCdFornecedor(int cdFornecedor) {
		this.cdFornecedor = cdFornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	
	
	
	

}
