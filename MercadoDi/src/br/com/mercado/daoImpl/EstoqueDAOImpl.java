package br.com.mercado.daoImpl;

import javax.persistence.EntityManager;

import br.com.mercado.dao.EstoqueDAO;
import br.com.mercado.entity.Estoque;

public class EstoqueDAOImpl extends DaoImpl<Estoque, Integer> implements
		EstoqueDAO {

	public EstoqueDAOImpl(EntityManager em) {
		super(em);

	}

	@Override
	public void somar(int id, int quantidade) {
		em.getTransaction().begin();

		em.createNativeQuery(
				"UPDATE TB_DI_ESTOQUE  set QUANTIDADE = QUANTIDADE +"
						+ quantidade + " where PRODUTO_CD_PRODUTO =" + id)
				.executeUpdate();

		em.getTransaction().commit();

	}

	@Override
	public void deletar(int id) {
		em.getTransaction().begin();

		em.createNativeQuery(
				"DELETE FROM TB_DI_ESTOQUE WHERE PRODUTO_CD_PRODUTO ="+id)
				.executeUpdate();

		em.getTransaction().commit();

	}

}