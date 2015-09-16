package br.com.mercado.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.mercado.dao.UsuarioDAO;
import br.com.mercado.entity.Usuario;

public class UsuarioDaoImpl extends DaoImpl<Usuario, Integer> implements
		UsuarioDAO {

	public UsuarioDaoImpl(EntityManager em) {
		super(em);

	}

	@Override
	public Usuario logar(String nomeUsuario, String senha) {
		try {
			Usuario usuario = (Usuario) em
					.createQuery(
							"SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha")
					.setParameter("name", nomeUsuario)
					.setParameter("senha", senha).getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}



}
