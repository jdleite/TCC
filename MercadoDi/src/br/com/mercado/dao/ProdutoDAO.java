package br.com.mercado.dao;

import java.util.List;

import br.com.mercado.entity.Produto;

public interface ProdutoDAO extends DAO<Produto,Integer> {
	List<Produto> listarProduto();
    List<Produto>listarNome();
    void alterarPreco(int id,double preco);
    
}
