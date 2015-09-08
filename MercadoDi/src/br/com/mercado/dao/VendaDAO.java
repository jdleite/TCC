package br.com.mercado.dao;

import java.util.List;

import br.com.mercado.entity.Produto;
import br.com.mercado.entity.Venda;

public interface VendaDAO  extends DAO<Venda, Integer>{
	
	 void baixaEstoque(int id, int quantidade);
	 	
	 List<Produto>  nomePreco(int cd) ;
	

}
