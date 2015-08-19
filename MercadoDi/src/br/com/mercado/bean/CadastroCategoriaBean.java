package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.mercado.daoImpl.CategoriaDAOImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class CadastroCategoriaBean {

	private CategoriaDAOImpl dao;
	
	private Categoria categoria;
	

	
	@PostConstruct
	private void init(){
		EntityManager em = EMFactorySingleton
				.getInstance().createEntityManager();
		dao = new CategoriaDAOImpl(em);
		categoria = new Categoria();
	}
	
	
	
	public void cadastrar(){
		FacesMessage msg;
		try {
			dao.insert(getCategoria());
			msg = new FacesMessage("Cadastrado com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao Cadastrar");
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










