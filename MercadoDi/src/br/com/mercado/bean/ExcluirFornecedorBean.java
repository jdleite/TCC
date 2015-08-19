package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.mercado.dao.FornecedorDAO;
import br.com.mercado.daoImpl.FornecedorDAOImpl;
import br.com.mercado.entity.Fornecedor;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.exception.IdNotFoundException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@ViewScoped
public class ExcluirFornecedorBean {
	private Fornecedor fornecedor;
	private List<Fornecedor> lista;
	private FornecedorDAO dao;

	@PostConstruct
	private void init() {
		dao = new FornecedorDAOImpl(EMFactorySingleton.getInstance()
				.createEntityManager());

		lista = dao.listarFornecedor();
	}

	public void excluir() {
		FacesMessage msg = null ;
		try {
			dao.delete(fornecedor.getCdFornecedor());
			lista.remove(fornecedor);
			msg = new FacesMessage("Excluido com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao Excluir!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getLista() {
		return lista;
	}

	public void setLista(List<Fornecedor> lista) {
		this.lista = lista;
	}

}
