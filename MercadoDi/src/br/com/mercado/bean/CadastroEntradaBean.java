package br.com.mercado.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.mercado.dao.EntradaDao;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.EntradaDAOImpl;
import br.com.mercado.daoImpl.ProdutoDAOImpl;
import br.com.mercado.entity.Entrada;
import br.com.mercado.entity.Produto;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class CadastroEntradaBean {

	private Entrada entrada;
	private EntradaDao dao;
	private int cdProduto;
	private ProdutoDAO daoProd;
	private Produto produto;
	private int id;
	private int quantidade;

	@PostConstruct
	public void init() {
		dao = new EntradaDAOImpl(EMFactorySingleton.getInstance()
				.createEntityManager());
		daoProd = new ProdutoDAOImpl(EMFactorySingleton.getInstance()
				.createEntityManager());
		entrada = new Entrada();
		entrada.setDtCompra(Calendar.getInstance());
		entrada.setDtValidade(Calendar.getInstance());
		

	}

	public void cadastrar() {
		FacesMessage msg;
		try {

		    daoProd.alterarPreco(cdProduto,entrada.getPrecoVenda());
			produto = daoProd.findById(cdProduto);
			entrada.setProduto(produto);
			dao.insert(entrada);
			dao.somar(cdProduto, entrada.getQtCompra());
			msg = new FacesMessage("Cadastrado com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();

			msg = new FacesMessage("Cadastrado com Sucesso!");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	public int getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(int cdProduto) {
		this.cdProduto = cdProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
