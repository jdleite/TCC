package br.com.mercado.view;

import javax.persistence.EntityManager;

import br.com.mercado.singleton.EMFactorySingleton;

public class Teste {
	public static void main(String[] args) {
		 EntityManager em =
					EMFactorySingleton.getInstance()
					.createEntityManager();
	}

}
