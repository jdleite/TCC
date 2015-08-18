package br.com.mercado.dao;

import br.com.mercado.exception.DBCommitException;
import br.com.mercado.exception.IdNotFoundException;

public interface  DAO<T,K> {
	
	void insert (T entity)throws DBCommitException;
	void update (T entity) throws DBCommitException;
	void delete (K id)throws DBCommitException,IdNotFoundException;
	T findById(K id);

}
