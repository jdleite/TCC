package br.com.mercado.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mercado.entity.Produto;
import br.com.mercado.singleton.EMFactorySingleton;

public class Teste {
	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton.getInstance()
				.createEntityManager();

		Query query = em.createQuery("select p from Produto p",Produto.class);

		
		List<Produto> produtos =  query.getResultList();
		for (Produto produto : produtos) {
		System.out.println(produto.getCategoria().getDescricao());
		}

	}
}
