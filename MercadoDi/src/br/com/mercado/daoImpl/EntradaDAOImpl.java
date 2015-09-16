package br.com.mercado.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mercado.dao.EntradaDAO;
import br.com.mercado.entity.Entrada;

public class EntradaDaoImpl extends DaoImpl<Entrada, Integer> implements
		EntradaDAO {

	public EntradaDaoImpl(EntityManager em) {
		super(em);

	}

	@Override
	public List<Entrada> listarEntrada() {
		TypedQuery<Entrada> query = em.createQuery("select e from Entrada e",Entrada.class);
		return query.getResultList();
	}

	@Override
	public void somar(int id, int quantidade) {
		em.getTransaction().begin();
		em.createNativeQuery(
				"UPDATE TB_DI_PRODUTO  set ESTOQUE = ESTOQUE +"
						+ quantidade + " where CD_PRODUTO =" + id)
				.executeUpdate();

		em.getTransaction().commit();
		
		/*em.createQuery("update Produto set estoque = estoque + :quantidade where cdProduto = :id")
		.setParameter("quantidade", quantidade)
		.setParameter("id", id).executeUpdate();
		*/
	}

	@Override
	public void deletar(int id) {
		em.getTransaction().begin();
		em.createNativeQuery("DELETE FROM TB_DI_ENTRADA_PRODUTO  WHERE CD_PRODUTO = " + id).executeUpdate();
		
		em.getTransaction().commit();
		
	}

	@Override
	public void alterarEstoque(int id, int quantidade) {
		em.getTransaction().begin();
		em.createNativeQuery(
				"UPDATE TB_DI_PRODUTO  set ESTOQUE = ESTOQUE -"
						+ quantidade + " where CD_PRODUTO =" + id)
				.executeUpdate();

		em.getTransaction().commit();
		
	}

	@Override
	public int buscaCodigo(int barra) {
		return em.createQuery("select p.cdProduto from Produto p where "
				+ "p.cdBarra like :n",Integer.class)
				.setParameter("n",barra).getSingleResult();
	}


	@Override
	public List<Entrada> buscarEntrada(int barra) {
		return em.createQuery(" from Entrada p where "
				+ "p.produto.cdProduto like :n",Entrada.class)
				.setParameter("n",barra).getResultList();
	}

	

	
	

	

}
