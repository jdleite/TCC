package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.ProdutoDAOImpl;
import br.com.mercado.entity.Produto;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@ViewScoped
public class ListaProdutoBean {

	private List<Produto> lista;
	public ProdutoDAO dao;

	@PostConstruct
	public void init() {
		dao = new ProdutoDAOImpl(EMFactorySingleton.getInstance()
				.createEntityManager());

		lista = dao.listarProduto();
	}

	public List<Produto> getLista() {
		return lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}

}
