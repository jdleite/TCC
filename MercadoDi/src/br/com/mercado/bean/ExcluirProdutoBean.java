package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.ProdutoDAOImpl;
import br.com.mercado.entity.Produto;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.exception.IdNotFoundException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class ExcluirProdutoBean {
	
	private Produto produto;
	private List<Produto> lista;
	private ProdutoDAO dao;
	
	@PostConstruct
	public void init(){
		dao = new ProdutoDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		lista = dao.listarProduto();
	}
	
	public void excluir(){
		FacesMessage msg = null;
		try {
			dao.delete(produto.getCdProduto());
			lista.remove(produto);
			msg = new FacesMessage("Excluido com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao Excluir!");
		}
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getLista() {
		return lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}

}
