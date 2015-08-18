package br.com.mercado.dao;

import java.util.List;

import br.com.mercado.entity.Entrada;

public interface  EntradaDao  extends DAO<Entrada,Integer>{
	List<Entrada> listarEntrada();
}
