package br.com.mercado.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.entity.Categoria;


public class CategoriaDaoImpl extends DaoImpl<Categoria, Integer> implements CategoriaDAO{

	
	public CategoriaDaoImpl(EntityManager em) {
		super(em);
	}
	
	
	public List<Categoria> listarCategoria() {
		TypedQuery<Categoria> query = 
				em.createQuery("select c from Categoria c",Categoria.class);
			return query.getResultList();
	}

}
