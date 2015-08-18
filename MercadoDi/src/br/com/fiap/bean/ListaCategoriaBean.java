package br.com.fiap.bean;

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

	private Categoria categoria;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}

