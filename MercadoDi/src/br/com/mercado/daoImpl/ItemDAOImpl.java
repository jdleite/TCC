package br.com.mercado.daoImpl;

import javax.persistence.EntityManager;

import br.com.mercado.dao.ItemDAO;
import br.com.mercado.entity.ItemVenda;

public class ItemDaoImpl extends DaoImpl<ItemVenda,Integer> implements ItemDAO {

	public ItemDaoImpl(EntityManager em) {
		super(em);
	}
	
	

}
