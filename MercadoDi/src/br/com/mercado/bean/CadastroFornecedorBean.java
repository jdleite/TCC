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
public class CadastroFornecedorBean {
	private Fornecedor fornecedor;
	
	private FornecedorDAO dao;
	
	
	
	@PostConstruct
	private void init(){
		dao = new FornecedorDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		
		fornecedor = new Fornecedor();		
		
		
		
	}
	
	public void cadastrar(){
		MensageView m = new MensageView();
		try {
			dao.insert(fornecedor);
			m.info("Cadastrado com Sucesso");
		} catch (DBCommitException e) {
			e.printStackTrace();
			m.error("Erro ao Cadastrar");
		}
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	

}
