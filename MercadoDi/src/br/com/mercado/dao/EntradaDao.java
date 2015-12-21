package br.com.mercado.dao;

import java.util.List;

import br.com.mercado.entity.Entrada;


public interface  EntradaDAO  extends DAO<Entrada,Integer>{
	
	
	List<Entrada> listarEntrada();
     
    
     int buscaCodigo(int barra);
     
    
     List<Entrada> buscarEntrada(int barra);
	 
 	
 	void somar(int id, int quantidade);
	
 	void deletar(int id);
	
 	void alterarEstoque(int id,int quantidade);
	 
 	
 	List<Entrada> produtosVencimento();

}
