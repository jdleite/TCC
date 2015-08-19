package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercado.dao.FornecedorDAO;
import br.com.mercado.daoImpl.FornecedorDAOImpl;
import br.com.mercado.entity.Fornecedor;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@ViewScoped
public class ListaFornecedorBean {
	private List<Fornecedor> lista;
	
	private  FornecedorDAO dao;
	

	@PostConstruct
	private void init(){
		dao = new FornecedorDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		
		lista = dao.listarFornecedor();
	}
	
	public List<Fornecedor> getLista() {
		return lista;
	}

	public void setLista(List<Fornecedor> lista) {
		this.lista = lista;
	}

	
	
	

}
