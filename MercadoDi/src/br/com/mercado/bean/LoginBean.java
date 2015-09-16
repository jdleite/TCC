package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.mercado.dao.UsuarioDAO;
import br.com.mercado.daoImpl.UsuarioDaoImpl;
import br.com.mercado.entity.Usuario;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@ViewScoped
public class LoginBean {
	private UsuarioDAO dao;
	private Usuario usuario;

	@PostConstruct
	public void init() {
		dao = new UsuarioDaoImpl(EMFactorySingleton.getInstance()
				.createEntityManager());
		usuario = new Usuario();
		
	}
	public String logar() {
		MensageView m = new MensageView();
		
		usuario = dao.logar(usuario.getNomeUsuario(),
				usuario.getSenha());
		if (usuario == null) {
			
			m.error("Usuário não encontrado!");
			
			return null;
		} else {
			
			
			return "/index";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
