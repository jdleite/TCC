package br.com.mercado.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.dao.EntradaDAO;
import br.com.mercado.dao.ItemDAO;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.dao.UsuarioDAO;
import br.com.mercado.dao.VendaDAO;
import br.com.mercado.daoImpl.CategoriaDaoImpl;
import br.com.mercado.daoImpl.EntradaDaoImpl;
import br.com.mercado.daoImpl.ItemDaoImpl;
import br.com.mercado.daoImpl.ProdutoDaoImpl;
import br.com.mercado.daoImpl.UsuarioDaoImpl;
import br.com.mercado.daoImpl.VendaDaoImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.entity.ItemVenda;
import br.com.mercado.entity.Produto;
import br.com.mercado.entity.Usuario;
import br.com.mercado.entity.Venda;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

public class testeVenda3 {
	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton.getInstance()
				.createEntityManager();
		String[] nome;
		int[] quantidade;
		Usuario u = new Usuario();
		UsuarioDAO uDao = new UsuarioDaoImpl(em);
		Categoria c = new Categoria();
		CategoriaDAO cDao = new CategoriaDaoImpl(em);
		Venda v = new Venda();
		VendaDAO vDao = new VendaDaoImpl(em);
		Produto prod = new Produto();
		List<Produto> pr = new ArrayList<Produto>();
		EntradaDAO eDao = new EntradaDaoImpl(em);
		ProdutoDAO pDao = new ProdutoDaoImpl(em);
		ItemVenda item = new ItemVenda();
		ItemVenda item2 = new ItemVenda();
		List<ItemVenda> itens = new ArrayList<ItemVenda>();
		List<String> items = new ArrayList<String>();
		List<Double> valor = new ArrayList<Double>();
		ItemDAO iDao = new ItemDaoImpl(em);
		
		
	
		
		System.out.println(eDao.buscarEntrada(eDao.buscaCodigo(1)));
		
		
		
	
	
	

	
		
	
	}

}
