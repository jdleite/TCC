package br.com.mercado.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.entity.Produto;

public class ProdutoDAOImpl extends DaoImpl<Produto, Integer> implements ProdutoDAO{

	public ProdutoDAOImpl(EntityManager em) {
		super(em);
	}
	
	@Override
	public List<Produto> listarProduto() {
		TypedQuery<Produto> query = 
				em.createQuery("select p from Produto p",Produto.class);
			return query.getResultList();
	}

	@Override
	public List<Produto> listarNome() {
		TypedQuery<Produto> query = 
				em.createQuery("select from Produto p where p.nmProduto",Produto.class);
			return query.getResultList();
	}

	
			
}
