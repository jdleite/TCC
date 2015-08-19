package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.daoImpl.CategoriaDAOImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@ViewScoped
public class ListaCategoriaBean {
	
	
	private List<Categoria> lista;

	private CategoriaDAO dao;

	@PostConstruct
	private void init() {
		dao = new CategoriaDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		lista = dao.listarCategoria();
	}
	
	

	public List<Categoria> getLista() {
		return lista;
	}

	public void setLista(List<Categoria> lista) {
		this.lista = lista;
	}

	
}

