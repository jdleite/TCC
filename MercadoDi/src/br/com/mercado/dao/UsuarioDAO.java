package br.com.mercado.dao;

import br.com.mercado.entity.Usuario;

public interface UsuarioDAO extends DAO<Usuario, Integer> {
	
	 Usuario logar(String nomeUsuario, String senha);
	 
	 

	

}
