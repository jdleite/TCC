package br.com.mercado.dao;

import br.com.mercado.entity.Venda;

public interface VendaDAO  extends DAO<Venda, Integer>{
	
	 void baixaEstoque(int id, int quantidade);
	 void buscarNomePreco(int id);
	

}
