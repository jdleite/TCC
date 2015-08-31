package br.com.mercado.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.mercado.dao.EntradaDao;
import br.com.mercado.entity.Entrada;

public class EntradaDAOImpl extends DaoImpl<Entrada, Integer> implements
		EntradaDao {

	public EntradaDAOImpl(EntityManager em) {
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
	
	

	

}
