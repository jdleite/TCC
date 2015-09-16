package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.mercado.dao.EntradaDAO;
import br.com.mercado.daoImpl.EntradaDaoImpl;
import br.com.mercado.entity.Entrada;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.exception.IdNotFoundException;
import br.com.mercado.singleton.EMFactorySingleton;
@ManagedBean
@ViewScoped
public class ExcluirEntradaBean {
	private Entrada entrada;
	private EntradaDAO dao;
	
	@PostConstruct
	private void init(){
		dao  = new EntradaDaoImpl(EMFactorySingleton.getInstance().createEntityManager());
		entrada = new Entrada();
		
	}
	
	
	public void excluir(){
		FacesMessage msg = null;
		try {
			dao.delete(entrada.getCdEntrada());
			dao.alterarEstoque(entrada.getProduto().getCdProduto(), entrada.getQtCompra());
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
