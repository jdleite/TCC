package br.com.mercado.daoImpl;

import javax.persistence.EntityManager;

import br.com.mercado.dao.ItemDAO;
import br.com.mercado.entity.ItemVenda;

public class ItemDAOImpl extends DaoImpl<ItemVenda,Integer> implements ItemDAO {

	public ItemDAOImpl(EntityManager em) {
		super(em);
	}
	
	

}
