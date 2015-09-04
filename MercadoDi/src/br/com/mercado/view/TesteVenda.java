package br.com.mercado.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercado.dao.ItemDAO;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.dao.VendaDAO;
import br.com.mercado.daoImpl.ItemDAOImpl;
import br.com.mercado.daoImpl.ProdutoDAOImpl;
import br.com.mercado.daoImpl.VendaDAOImpl;
import br.com.mercado.entity.ItemVenda;
import br.com.mercado.entity.Produto;
import br.com.mercado.entity.Venda;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

public class TesteVenda {
	public static void main(String[] args)  {
		double preco = 0;
		EntityManager em = EMFactorySingleton.getInstance()
				.createEntityManager();

		Venda v = new Venda();
		VendaDAO vDao = new VendaDAOImpl(em);
		Produto prod = new Produto();
		ProdutoDAO pDao = new ProdutoDAOImpl(em);
		ItemVenda item = new ItemVenda();
		ItemVenda item2 = new ItemVenda();
		List<ItemVenda> itens = new ArrayList<ItemVenda>();
		ItemDAO iDao = new ItemDAOImpl(em);
		
		Produto prI = pDao.findById(1);

		item.setPrecoItem(20);
		item.setQtItem(1);
		item.setProduto(prI);
		item2.setPrecoItem(30);
		item2.setProduto(prI);
		item2.setQtItem(50);
		
		itens.add(item);
		itens.add(item2);
		
	
		for(ItemVenda i: itens){
			preco += i.getPrecoItem();
			
			
		}
		System.out.println(preco);
		v.setTotal(preco);
		v.setItensVenda(itens);
		for(ItemVenda i: itens){
		vDao.baixaEstoque(i.getProduto().getCdProduto(),i.getQtItem());
		
		}
		
		
		try {
			
			vDao.insert(v);
		} catch (DBCommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
