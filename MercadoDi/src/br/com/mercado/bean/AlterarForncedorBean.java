package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.mercado.dao.FornecedorDAO;
import br.com.mercado.daoImpl.FornecedorDAOImpl;
import br.com.mercado.entity.Fornecedor;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class AlterarForncedorBean {

	private Fornecedor fornecedor;
	private FornecedorDAO dao;
	
	@PostConstruct
	private void init(){
		dao = new FornecedorDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		
		fornecedor = new Fornecedor();
		
	}
	
	public void alterar(){
		MensageView m = new MensageView();
		try {
			dao.update(fornecedor);
			m.info("Alterado com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
			m.error("Erro ao Alterar!");
		}
	}
	
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	
}
