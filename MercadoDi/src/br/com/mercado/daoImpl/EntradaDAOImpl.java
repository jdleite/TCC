package br.com.mercado.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mercado.dao.EntradaDao;
import br.com.mercado.entity.Entrada;

public class EntradaDAOImpl extends DaoImpl<Entrada, Integer> implements
		EntradaDao {

	public EntradaDAOImpl(EntityManager em) {
		super(em);

	}

	@Override
	public List<Entrada> listarEntrada() {
		TypedQuery<Entrada> query = em.createQuery("select e from Entrada e",Entrada.class);
		return query.getResultList();
	}

}
