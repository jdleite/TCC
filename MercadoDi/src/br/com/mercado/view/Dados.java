package br.com.mercado.view;

import javax.persistence.EntityManager;

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
import br.com.mercado.singleton.EMFactorySingleton;

public class Dados {
	public static void main(String[] args) {
		EntityManager em = EMFactorySingleton.getInstance()
				.createEntityManager();

		Categoria cat5 = new Categoria();
		Categoria cat4 = new Categoria();
		Categoria cat3 = new Categoria();
		Categoria cat2 = new Categoria();
		Produto prod = new Produto();
		ProdutoDAO pDao = new ProdutoDAOImpl(em);
		Estoque esto = new Estoque();
	    EstoqueDAO eDao = new EstoqueDAOImpl(em);
	    Categoria cat = new Categoria();
	    CategoriaDAO cDao = new CategoriaDAOImpl(em);
	    Fornecedor forn = new Fornecedor();
	    FornecedorDAO fDao = new FornecedorDAOImpl(em);

	    
	    cat.setUnidade("Lata");
	    cat.setTipo("Bebida");
	    cat2.setUnidade("Garrafa");
	    cat2.setTipo("Bebida");
	    cat3.setUnidade("Caixa");
	    cat3.setTipo("Bebida");
	    cat4.setUnidade("Saco");
	    cat4.setTipo("Não Perecivel");
	    cat5.setUnidade("Pacote");
	    cat5.setTipo("Não Perecivel");
	   //----------------------------------------
	   forn.setNome("Soma");
	    forn.setCep("123456");
	    forn.setEndereco("Miguel fernandes");
	    forn.setNumero("88");
	    forn.setTelefone("205939999");
	    forn.setBairro("Limoeiro");
	   //------------------------------------------
	/*   forn = fDao.findById(1);
	    cat = cDao.findById(1);
	    
	    prod.setNmProduto("Skol");
	    prod.setCdBarra(123456);
	    prod.setPeso("350 ml");
	    prod.setFornecedor(forn);
	    prod.setCategoria(cat);
	   //---------------------------------------- 
	    cat2 = cDao.findById(1);
	    prod.setNmProduto("Kaise");
	    prod.setCdBarra(321456);
	    prod.setPeso("350 ml");
	    prod.setFornecedor(forn);
	    prod.setCategoria(cat2);
	   
	    */
	    
	    
	    try {
			cDao.insert(cat);
			cDao.insert(cat2);
			cDao.insert(cat3);
			cDao.insert(cat4);
			cDao.insert(cat5);
			fDao.insert(forn);
			pDao.insert(prod);
		} catch (DBCommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    
	
	}

}
