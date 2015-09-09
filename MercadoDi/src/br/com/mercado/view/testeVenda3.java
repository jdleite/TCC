package br.com.mercado.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercado.dao.EntradaDao;
import br.com.mercado.dao.ItemDAO;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.dao.VendaDAO;
import br.com.mercado.daoImpl.EntradaDAOImpl;
import br.com.mercado.daoImpl.ItemDAOImpl;
import br.com.mercado.daoImpl.ProdutoDAOImpl;
import br.com.mercado.daoImpl.VendaDAOImpl;
import br.com.mercado.entity.ItemVenda;
import br.com.mercado.entity.Produto;
import br.com.mercado.entity.Venda;
import br.com.mercado.singleton.EMFactorySingleton;

public class testeVenda3 {
	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton.getInstance()
				.createEntityManager();
		Venda v = new Venda();
		VendaDAO vDao = new VendaDAOImpl(em);
		Produto prod = new Produto();
		EntradaDao eDao = new EntradaDAOImpl(em);
		ProdutoDAO pDao = new ProdutoDAOImpl(em);
		ItemVenda item = new ItemVenda();
		ItemVenda item2 = new ItemVenda();
		List<ItemVenda> itens = new ArrayList<ItemVenda>();
		ItemDAO iDao = new ItemDAOImpl(em);

	 
	  pDao.alterarPreco(2, 52);
	  eDao.somar(2, 356);

	}

}
