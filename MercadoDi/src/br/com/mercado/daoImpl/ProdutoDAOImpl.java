package br.com.mercado.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.entity.Produto;

public class ProdutoDaoImpl extends DaoImpl<Produto, Integer> implements ProdutoDAO{

	public ProdutoDaoImpl(EntityManager em) {
		super(em);
	}
	
	@Override
	public List<Produto> listarProduto() {
		TypedQuery<Produto> query = 
				em.createQuery("select p from Produto p",Produto.class);
			return query.getResultList();
	}

	@Override
	public List<Produto> listarNome() {
		TypedQuery<Produto> query = 
				em.createQuery("select from Produto p where p.nmProduto",Produto.class);
			return query.getResultList();
	}

	@Override
	public void alterarPreco(int id, double preco) {
		em.getTransaction().begin();
		em.createNativeQuery(
				"UPDATE TB_DI_PRODUTO SET PRECO = "+ preco +" WHERE CD_PRODUTO = " + id)
				.executeUpdate();

		em.getTransaction().commit();	
		
	}

	@Override
	public List<Produto> buscarNomeProduto(String nome) {
		return em.createQuery("from Produto p where "
				+ "upper(p.nmProduto) like upper(:n)",Produto.class)
				.setParameter("n","%"+nome+"%").getResultList();
	}

	@Override
	public List<String> autoCompletePorNome(String nome) {
		return em.createQuery("select p.nmProduto from Produto p where "
				+ "upper(p.nmProduto) like upper(:n)",String.class)
				.setParameter("n","%"+nome+"%").getResultList();
	}

	@Override
	public boolean encotrarCodigoBarra(int cd) {
		try {
			em.createQuery("from Produto p where  p.cdBarra = :cd")
			.setParameter("cd", cd).getSingleResult();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	
			
}
