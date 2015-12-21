package br.com.mercado.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.dao.EntradaDAO;
import br.com.mercado.dao.FornecedorDAO;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.CategoriaDaoImpl;
import br.com.mercado.daoImpl.EntradaDaoImpl;
import br.com.mercado.daoImpl.FornecedorDaoImpl;
import br.com.mercado.daoImpl.ProdutoDaoImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.entity.Entrada;
import br.com.mercado.entity.Fornecedor;
import br.com.mercado.entity.Produto;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

public class Teste {
	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		
	


	    Produto prod = new Produto();
	    ProdutoDAO pDao = new ProdutoDaoImpl(em);
	    Categoria cat = new Categoria();
	    Categoria cat2 = new Categoria();
	    Categoria cat3 = new Categoria();
	    CategoriaDAO cDao = new CategoriaDaoImpl(em);
	    Fornecedor forn = new Fornecedor();
        FornecedorDAO fDao = new FornecedorDaoImpl(em);
        Entrada ent = new Entrada();
        EntradaDAO eDao = new EntradaDaoImpl(em);
        
        
       
        
        
        
        cat.setUnidade("Lata");
        cat.setTipo("Bebida");
        cat.setDescricao("Refrigerante");
        cat2.setUnidade("Lata");
        cat2.setTipo("Bebida");
        cat2.setDescricao("Cerveja");	
        cat3.setUnidade("Lata");
        cat3.setTipo("Bebida");
        cat3.setDescricao("Suco");	
        forn.setBairro("Limoeiro");
        forn.setCep("123");
        forn.setEndereco("Miguel Fernandes");
        forn.setNome("SOMA");
        forn.setTelefone("20593999");
        
      
        
   
        
        try {
			fDao.insert(forn);
			cDao.insert(cat);
			cDao.insert(cat2);
			cDao.insert(cat3);
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
