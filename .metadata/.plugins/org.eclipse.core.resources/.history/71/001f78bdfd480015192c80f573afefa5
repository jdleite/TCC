package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.dao.FornecedorDAO;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.CategoriaDAOImpl;
import br.com.mercado.daoImpl.FornecedorDAOImpl;
import br.com.mercado.daoImpl.ProdutoDAOImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.entity.Fornecedor;
import br.com.mercado.entity.Produto;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class CadastroProdutoBean {
	
	private Produto produto;
	private Categoria categoria;
	private Fornecedor fornecedor;
	private FornecedorDAO daoFor;
	private ProdutoDAO dao;
	private CategoriaDAO daoCat;
	private int cdCategoria;
	private int cdFornecedor;

	@PostConstruct
	private void init(){
		dao = new ProdutoDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		daoCat = new CategoriaDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		daoFor = new FornecedorDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		categoria = new Categoria();
		produto = new Produto();
		
	}
	
	
	public void cadastrar(){
		FacesMessage msg;
		try {
			categoria = daoCat.findById(cdCategoria);
			fornecedor = daoFor.findById(cdFornecedor);
			produto.setFornecedor(fornecedor);
			produto.setCategoria(categoria);
			dao.insert(produto);
			msg  = new FacesMessage("Cadastrado com Sucesso!");
		} catch (DBCommitException e) {			
			e.printStackTrace();
			msg  = new FacesMessage("Cadastrado com Sucesso!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	


	public int getCdCategoria() {
		return cdCategoria;
	}


	public void setCdCategoria(int cdCategoria) {
		this.cdCategoria = cdCategoria;
	}


	public int getCdFornecedor() {
		return cdFornecedor;
	}


	public void setCdFornecedor(int cdFornecedor) {
		this.cdFornecedor = cdFornecedor;
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	

}
