package br.com.mercado.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mercado.dao.ItemDAO;
import br.com.mercado.entity.ItemVenda;



public class ItemDaoImpl extends DaoImpl<ItemVenda,Integer> implements ItemDAO {

	
	public ItemDaoImpl(EntityManager em) {
		super(em);
	}

	
	@Override
	public List<ItemVenda> buscarItem(long id) {
		TypedQuery<ItemVenda> query = 
				em.createQuery("select i from ItemVenda i where venda.cdVenda =  :id",ItemVenda.class).setParameter("id", id);
			return query.getResultList();
	}
	
	

}
