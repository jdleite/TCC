package br.com.mercado.daoImpl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.mercado.dao.VendaDAO;
import br.com.mercado.entity.Produto;
import br.com.mercado.entity.Venda;


public class VendaDaoImpl extends DaoImpl<Venda, Integer> implements VendaDAO {

	
	public VendaDaoImpl(EntityManager em) {
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
	public List<Produto> nomePreco(long cd) {
		TypedQuery<Produto> query =
				em.createQuery("from Produto p where p.cdBarra = :cd",Produto.class);
			query.setParameter("cd",cd);
			return query.getResultList();
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BigDecimal> maisVendido() {
		Query query =  em.createNativeQuery("select CD_PRODUTO from (select CD_PRODUTO,count(CD_PRODUTO)QUANTIDADE from TB_DI_ITEM_VENDA GROUP BY CD_PRODUTO ORDER BY QUANTIDADE desc)");
			return query.getResultList();
	}

	
	
	@Override
	public long maisVendidos(int id) {
		Query query =  em.createQuery("select count(qtItem) from ItemVenda where produto.cdProduto = :id ").setParameter("id", id);
		return (Long) query.getSingleResult();
	}

	
	@Override
	public long vendaBuscarBarra(long cd) {
		TypedQuery<Produto> query =
				em.createQuery("from Produto p where p.cdBarra = :cd",Produto.class);
			query.setParameter("cd",cd);
			return cd;
			
	}

}
