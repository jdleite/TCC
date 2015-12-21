package br.com.mercado.dao;

import java.util.List;

import br.com.mercado.entity.ItemVenda;


public interface ItemDAO extends DAO<ItemVenda,Integer>  {
	
	
	List<ItemVenda> buscarItem(long id);

}
