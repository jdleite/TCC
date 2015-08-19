package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.ProdutoDAOImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.entity.Produto;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class CadastroProdutoBean {
	
	private Produto produto;
	private Categoria categoria;
	private ProdutoDAO dao;

	@PostConstruct
	private void init(){
		dao = new ProdutoDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		categoria = new Categoria();
		produto = new Produto();
	}
	
	
	public void cadastrar(){
		FacesMessage msg;
		try {
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
	
	

}
