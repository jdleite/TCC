package br.com.mercado.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.dao.EntradaDAO;
import br.com.mercado.dao.ItemDAO;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.dao.VendaDAO;
import br.com.mercado.daoImpl.CategoriaDaoImpl;
import br.com.mercado.daoImpl.EntradaDaoImpl;
import br.com.mercado.daoImpl.ItemDaoImpl;
import br.com.mercado.daoImpl.ProdutoDaoImpl;
import br.com.mercado.daoImpl.VendaDaoImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.entity.Entrada;
import br.com.mercado.entity.ItemVenda;
import br.com.mercado.entity.Produto;
import br.com.mercado.entity.Venda;
import br.com.mercado.singleton.EMFactorySingleton;

public class testeVenda3 {
	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();

		
		Categoria c = new Categoria();
		CategoriaDAO cDao = new CategoriaDaoImpl(em);
		Venda v = new Venda();
		VendaDAO vDao = new VendaDaoImpl(em);
		Produto prod = new Produto();
		List<Produto> pr = new ArrayList<Produto>();
		EntradaDAO eDao = new EntradaDaoImpl(em);
		Entrada ent = new Entrada();
		ProdutoDAO pDao = new ProdutoDaoImpl(em);
		ItemVenda item = new ItemVenda();
		ItemVenda item2 = new ItemVenda();
		List<ItemVenda> itens = new ArrayList<ItemVenda>();
		List<String> items = new ArrayList<String>();
		List<Double> valor = new ArrayList<Double>();
		ItemDAO iDao = new ItemDaoImpl(em);

		/*
		  prod.setNmProduto("COCA");
		  int quantidade = 10; double tot = 1;
		  double y = tot + quantidade ;
		  
		  
		  
		  Mais[] ma = new Mais[10];
		  
		  for(int i = 0; i<2;i++){ 
			  ma[i] = new Mais();
		  ma[i].setNome(prod.getNmProduto()); ma[i].setQuantidade(quantidade);
		  ma[i].setTotal(tot);
		  
		  }
		  
		  List<Mais> ms = Arrays.asList(ma);
		  
		 
		 
		 
*/
		
		
	}
}
