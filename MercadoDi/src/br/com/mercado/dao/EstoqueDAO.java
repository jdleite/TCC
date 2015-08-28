package br.com.mercado.dao;

import br.com.mercado.entity.Estoque;

public interface  EstoqueDAO extends DAO<Estoque,Integer>{
	
	public void somar(int id, int quantidade);
	public void deletar(int id);

}
