package br.com.mercado.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mercado.dao.VendaDAO;
import br.com.mercado.entity.Produto;
import br.com.mercado.entity.Venda;

public class VendaDAOImpl extends DaoImpl<Venda, Integer> implements VendaDAO {

	public VendaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public void baixaEstoque(int id, int quantidade) {
		em.getTransaction().begin();
		em.createNativeQuery(
				"UPDATE TB_DI_PRODUTO  set ESTOQUE = ESTOQUE -"
						+ quantidade + " where CD_PRODUTO =" + id)
				.executeUpdate();

		em.getTransaction().commit();		
		
		
		
	}

	@Override
	public List<Produto> nomePreco(int cd) {
		TypedQuery<Produto> query =
				em.createQuery("from Produto t where t.cdBarra = :cd",Produto.class);
			query.setParameter("cd",cd);
			return query.getResultList();
	}


	
	

}
