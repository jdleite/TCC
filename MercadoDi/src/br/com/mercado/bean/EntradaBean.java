package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.mercado.daoImpl.EntradaDAOImpl;
import br.com.mercado.entity.Entrada;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class EntradaBean {

	private EntradaDAOImpl dao;
	private Entrada entrada;
	
	//Método de inicialização do ManagedBean
	@PostConstruct
	private void init(){
		EntityManager em = EMFactorySingleton
				.getInstance().createEntityManager();
		dao = new EntradaDAOImpl(em);
		entrada = new Entrada();
	}
	
	//Método para o clique do botão
	public void cadastrar(){
		FacesMessage msg;
		try {
			dao.insert(entrada);
			msg = new FacesMessage("Cadastrado!");
		} catch (DBCommitException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


}










