package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.mercado.dao.EntradaDao;
import br.com.mercado.daoImpl.EntradaDAOImpl;
import br.com.mercado.entity.Entrada;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.exception.IdNotFoundException;
import br.com.mercado.singleton.EMFactorySingleton;
@ManagedBean
@RequestScoped
public class ExcluirEntradaBean {
	private Entrada entrada;
	private EntradaDao dao;
	
	@PostConstruct
	private void init(){
		dao  = new EntradaDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		entrada = new Entrada();
		
	}
	
	
	public void excluir(){
		FacesMessage msg = null;
		try {
			dao.delete(entrada.getCdEntrada());
			msg = new FacesMessage("Excluido com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao Excluir");
		}
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	
	
	public Entrada getEntrada() {
		return entrada;
	}
	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}
	
	
	
	

}
