package br.com.mercado.view;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.dao.EstoqueDAO;
import br.com.mercado.dao.FornecedorDAO;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.CategoriaDAOImpl;
import br.com.mercado.daoImpl.EstoqueDAOImpl;
import br.com.mercado.daoImpl.FornecedorDAOImpl;
import br.com.mercado.daoImpl.ProdutoDAOImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.entity.Estoque;
import br.com.mercado.entity.Fornecedor;
import br.com.mercado.entity.Produto;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.exception.IdNotFoundException;
import br.com.mercado.singleton.EMFactorySingleton;

public class Teste {
	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton.getInstance()
				.createEntityManager();

/*		Produto prod = new Produto();
		ProdutoDAO pDao = new ProdutoDAOImpl(em);
		Estoque esto = new Estoque();
	    EstoqueDAO eDao = new EstoqueDAOImpl(em);
	    Categoria cat = new Categoria();
	    CategoriaDAO cDao = new CategoriaDAOImpl(em);
	    Fornecedor forn = new Fornecedor();
	    FornecedorDAO fDao = new FornecedorDAOImpl(em);
	    
	    
	    
	  
       
	    
	    forn = fDao.findById(3);
	    cat = cDao.findById(1);
	    esto = eDao.findById(1);
	   
	    Produto pr = new Produto();
	    pr = pDao.findById(2);
	    eDao.deletar(2);
	  
	    
	    try {
			pDao.delete(pr.getCdProduto());
		} catch (DBCommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   
	    System.out.println(pr.getCdProduto());
	    
	    
	    
	   prod.setNmProduto("Jefferson");
	   prod.setFornecedor(forn);
	   prod.setCategoria(cat);
	   
	   esto.setProduto(pr);
	   
	
	    int id = 14;
		em.getTransaction().begin();
	    
        em.createNativeQuery("UPDATE TB_DI_ESTOQUE  set QUANTIDADE = QUANTIDADE +"+ id +" where PRODUTO_CD_PRODUTO =11").executeUpdate();
         
         em.getTransaction().commit();
				
       */ 
	    
	    
        
	   


	}
}
