package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.mercado.dao.ItemDAO;
import br.com.mercado.daoImpl.ItemDaoImpl;
import br.com.mercado.entity.ItemVenda;
import br.com.mercado.singleton.EMFactorySingleton;


@ManagedBean
@ViewScoped
public class ListaItemBean {

	
	private long id;

	
	private ItemVenda item;

	
	private ItemDAO dao;

	
	private List<ItemVenda> lista;

	
	@PostConstruct
	private void init() {

		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		dao = new ItemDaoImpl(em);
		item = new ItemVenda();
	}

	
	public void buscar() {

		lista = dao.buscarItem(id);
	}

	
	public List<ItemVenda> getLista() {
		return lista;
	}

	
	public void setLista(List<ItemVenda> lista) {
		this.lista = lista;
	}

	
	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	
	public ItemVenda getItem() {
		return item;
	}

	
	public void setItem(ItemVenda item) {
		this.item = item;
	}

}
