package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.daoImpl.CategoriaDaoImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.exception.IdNotFoundException;
import br.com.mercado.singleton.EMFactorySingleton;


@ManagedBean
@ViewScoped
public class ListaCategoriaBean {

	
	private List<Categoria> lista;

	
	private CategoriaDAO dao;

	
	private Categoria categoria;

	
	@PostConstruct
	private void init() {
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		dao = new CategoriaDaoImpl(em);
		lista = dao.listarCategoria();
	}

	
	public void excluir() {
		MensageView m = new MensageView();
		try {

			lista.remove(categoria);
			dao.delete(categoria.getCdCategoria());

			m.info("Excluído com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			m.error("Erro ao Excluir");
		}

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
