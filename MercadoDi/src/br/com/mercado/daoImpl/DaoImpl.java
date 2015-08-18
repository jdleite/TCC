package br.com.mercado.daoImpl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.mercado.dao.DAO;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.exception.IdNotFoundException;

public class DaoImpl<T,K> implements DAO<T,K> {
	
protected EntityManager em;
	
	private Class<T> classe;

	@SuppressWarnings("unchecked")
	public DaoImpl(EntityManager em) {
		this.em = em;
		classe = 
			(Class<T>) ((ParameterizedType)
					getClass().getGenericSuperclass())
						.getActualTypeArguments()[0];
	}

	@Override
	public void insert(T entity) throws DBCommitException {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()){
				em.getTransaction().commit();
				throw new DBCommitException("Erro ao Persistir");
			}
		}
		
	}

	@Override
	public void update(T entity) throws DBCommitException {
		try{
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new DBCommitException("Erro ao Atualizar");
			
		}
		
	}

	@Override
	public void delete(K id) throws DBCommitException, IdNotFoundException {
		T entity = findById(id);
		if (entity == null) 
			throw new IdNotFoundException();
		try{
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new DBCommitException("Erro ao Remover");
		}
		
	}

	@Override
	public T findById(K id) {
		return em.find(classe, id);
		
	}



	

	

	

}
