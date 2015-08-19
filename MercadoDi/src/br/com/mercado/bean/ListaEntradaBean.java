package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercado.dao.EntradaDao;
import br.com.mercado.daoImpl.EntradaDAOImpl;
import br.com.mercado.entity.Entrada;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@ViewScoped
public class ListaEntradaBean {
	private List<Entrada> lista;

	private EntradaDao dao;
	
	
	@PostConstruct
	public void init(){
		dao = new EntradaDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		
		lista = dao.listarEntrada();
	}

	public List<Entrada> getLista() {
		return lista;
	}

	public void setLista(List<Entrada> lista) {
		this.lista = lista;
	}

	
	
	
	
}
