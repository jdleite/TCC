package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.mercado.dao.FornecedorDAO;
import br.com.mercado.daoImpl.FornecedorDaoImpl;
import br.com.mercado.entity.Fornecedor;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.exception.IdNotFoundException;
import br.com.mercado.singleton.EMFactorySingleton;


@ManagedBean
@ViewScoped
public class ListaFornecedorBean {

	
	private List<Fornecedor> lista;

	
	private Fornecedor fornecedor;

	
	private FornecedorDAO dao;

	
	@PostConstruct
	private void init() {

		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		dao = new FornecedorDaoImpl(em);

		lista = dao.listarFornecedor();
	}

	
	public void excluir() {
		MensageView m = new MensageView();
		try {
			lista.remove(fornecedor);
			dao.delete(fornecedor.getCdFornecedor());
			m.info("Excluido com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			m.error("Erro ao Excluir!");
		}

	}

	
	public List<Fornecedor> getLista() {
		return lista;
	}

	
	public void setLista(List<Fornecedor> lista) {
		this.lista = lista;
	}

	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
