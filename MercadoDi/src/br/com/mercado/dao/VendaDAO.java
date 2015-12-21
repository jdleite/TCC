package br.com.mercado.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.mercado.entity.Produto;
import br.com.mercado.entity.Venda;


public interface VendaDAO  extends DAO<Venda, Integer>{
	
	
 	void baixaEstoque(int id, int quantidade);
	 	
	
 	List<Produto>  nomePreco(long cd) ;
	 
	
 	List<BigDecimal> maisVendido();
	 
	
 	long maisVendidos(int id);
	 
	
 	long vendaBuscarBarra(long cd);
	 

	 
	 
	

}
