package br.com.mercado.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mercado.dao.FornecedorDAO;
import br.com.mercado.entity.Fornecedor;

public class FornecedorDAOImpl extends DaoImpl<Fornecedor, Integer> implements
		FornecedorDAO {

	public FornecedorDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Fornecedor> listarFornecedor() {
		TypedQuery<Fornecedor> query = em
				.createQuery("select f from Fornecedor f",Fornecedor.class);
		return query.getResultList();
	}

}
