package br.com.mercado.dao;

import java.util.List;

import br.com.mercado.entity.Fornecedor;

// TODO: Auto-generated Javadoc

public interface FornecedorDAO extends DAO<Fornecedor,Integer>{
	
	
	List<Fornecedor> listarFornecedor();

}
