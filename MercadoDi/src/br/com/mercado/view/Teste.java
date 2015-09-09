package br.com.mercado.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.dao.EntradaDao;
import br.com.mercado.dao.FornecedorDAO;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.CategoriaDAOImpl;
import br.com.mercado.daoImpl.EntradaDAOImpl;
import br.com.mercado.daoImpl.FornecedorDAOImpl;
import br.com.mercado.daoImpl.ProdutoDAOImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.entity.Entrada;
import br.com.mercado.entity.Fornecedor;
import br.com.mercado.entity.Produto;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

public class Teste {
	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton.getInstance()
				.createEntityManager();
		
	


	    Produto prod = new Produto();
	    ProdutoDAO pDao = new ProdutoDAOImpl(em);
	    Categoria cat = new Categoria();
	    CategoriaDAO cDao = new CategoriaDAOImpl(em);
	    Fornecedor forn = new Fornecedor();
        FornecedorDAO fDao = new FornecedorDAOImpl(em);
        Entrada ent = new Entrada();
        EntradaDao eDao = new EntradaDAOImpl(em);
        
        
       
        
        
        
        cat.setUnidade("Lata");
        cat.setTipo("Bebida");
        cat.setDescricao("Light");
	   
        forn.setBairro("Limoeiro");
        forn.setCep("123");
        forn.setEndereco("Miguel Fernandes");
        forn.setNome("SOMA");
        forn.setNumero("88");
        forn.setTelefone("20593999");
        
        prod.setFornecedor(forn);
        prod.setCdBarra(1);
        prod.setCategoria(cat);
        prod.setEstoque(1000);
        prod.setNmProduto("c");
        prod.setDescricao("LAta");
        prod.setPeso("350 ML");
        prod.setPreco(1.20);
        
        ent.setProduto(prod);
        ent.setQtCompra(100);
        ent.setPrecoVenda(5.90);
        
        
        
        
        try {
        	pDao.alterarPreco(1,ent.getPrecoVenda());
			cDao.insert(cat);
			fDao.insert(forn);
			pDao.insert(prod);
			eDao.insert(ent);
		} catch (DBCommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       List<Produto> lista = pDao.listarProduto();
        for (Produto i : lista){			
        	System.out.println(i.getNmProduto());
		}
        
        


	}
}
