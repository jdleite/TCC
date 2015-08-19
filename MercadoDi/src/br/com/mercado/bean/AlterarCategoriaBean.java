package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.daoImpl.CategoriaDAOImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class AlterarCategoriaBean {

	private CategoriaDAO dao;

	private Categoria categoria;

	@PostConstruct
	private void init() {
		categoria = new Categoria();
		dao = new CategoriaDAOImpl(EMFactorySingleton.getInstance()
				.createEntityManager());

		

	}

	public void alterar() {
		FacesMessage msg;

		try {
			dao.update(categoria);
			msg = new FacesMessage("Atualizado com Sucesso!");
		} catch (DBCommitException e) {
			msg = new FacesMessage("Erro ao Atualizar");
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
