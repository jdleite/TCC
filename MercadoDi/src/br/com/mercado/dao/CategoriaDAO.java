package br.com.mercado.dao;

import java.util.List;

import br.com.mercado.entity.Categoria;


public interface CategoriaDAO  extends DAO<Categoria,Integer>{
	
	
	List<Categoria> listarCategoria();

}
