package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.daoImpl.CategoriaDAOImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.exception.IdNotFoundException;
import br.com.mercado.singleton.EMFactorySingleton;
@ManagedBean
@ViewScoped
public class ExcluirCategoriaBean {
	
	private Categoria categoria;
	private CategoriaDAO dao;
	private List<Categoria> lista;
	
	
	@PostConstruct
	private void init(){
		dao = new CategoriaDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		lista = dao.listarCategoria();
	}
	
	public void excluir(){
		FacesMessage msg = null;
		try {
			lista.remove(categoria);
			dao.delete(categoria.getCdCategoria());		
			
			msg = new FacesMessage("Excluído com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao Excluir");
		}
		FacesContext.getCurrentInstance()
		.addMessage(null, msg);
	}
	
	
	
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getLista() {
		return lista;
	}

	public void setLista(List<Categoria> lista) {
		this.lista = lista;
	}

}
