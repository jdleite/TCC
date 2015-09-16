package br.com.mercado.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.persistence.EntityManager;

import org.primefaces.component.datatable.DataTable;

import br.com.mercado.dao.ItemDAO;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.dao.VendaDAO;
import br.com.mercado.daoImpl.ItemDaoImpl;
import br.com.mercado.daoImpl.ProdutoDaoImpl;
import br.com.mercado.daoImpl.VendaDaoImpl;
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
		VendaDAO vDao = new VendaDaoImpl(em);
		Produto prod = new Produto();
		ProdutoDAO pDao = new ProdutoDaoImpl(em);
		ItemVenda item = new ItemVenda();
		ItemVenda item2 = new ItemVenda();
		List<ItemVenda> itens = new ArrayList<ItemVenda>();
		ItemDAO iDao = new ItemDaoImpl(em);
		
		Produto prI = pDao.findById(1);

		item.setPrecoItem(20);
		item.setQtItem(1);
		item.setProduto(prI);
		item2.setPrecoItem(30);
		item2.setProduto(prI);
		item2.setQtItem(10);
		itens.add(item);
		itens.add(item2);

		item.setVenda(v);
		item2.setVenda(v);
	
		v.setTotal((item2.getPrecoItem()* item2.getQtItem())+(item.getPrecoItem() * item.getQtItem()));
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
