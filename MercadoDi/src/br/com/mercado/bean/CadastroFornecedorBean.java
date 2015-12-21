package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.com.mercado.dao.FornecedorDAO;
import br.com.mercado.daoImpl.FornecedorDaoImpl;
import br.com.mercado.entity.Fornecedor;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

// TODO: Auto-generated Javadoc

@ManagedBean
@RequestScoped
public class CadastroFornecedorBean {

	
	private Fornecedor fornecedor;

	
	private FornecedorDAO dao;

	
	@PostConstruct
	private void init() {

		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		dao = new FornecedorDaoImpl(em);
		fornecedor = new Fornecedor();

	}


	public void cadastrar() {
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
