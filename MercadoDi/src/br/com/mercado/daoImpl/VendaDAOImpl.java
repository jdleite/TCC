package br.com.mercado.daoImpl;

import javax.persistence.EntityManager;

import br.com.mercado.dao.VendaDAO;
import br.com.mercado.entity.Venda;

public class VendaDAOImpl extends DaoImpl<Venda, Integer> implements VendaDAO {

	public VendaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public void baixaEstoque(int id, int quantidade) {
		em.getTransaction().begin();
		em.createNativeQuery(
				"UPDATE TB_DI_PRODUTO  set ESTOQUE = ESTOQUE -"
						+ quantidade + " where CD_PRODUTO =" + id)
				.executeUpdate();

		em.getTransaction().commit();		
		
	}

	@Override
	public void buscarNomePreco(int id) {
		em.getTransaction().begin();
		em.createNativeQuery(
				"select PRECO_VENDA,P.NM_PRODUTO from TB_DI_ENTRADA_PRODUTO E INNER JOIN TB_DI_PRODUTO P ON (P.CD_PRODUTO = E.CD_PRODUTO)" +

                 "where CD_ENTRADA in(select max(CD_ENTRADA) from TB_DI_ENTRADA_PRODUTO where E.CD_PRODUTO = +" + id)
				.executeUpdate();
		
	}
	
	

}
