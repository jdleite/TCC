package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercado.dao.EntradaDAO;
import br.com.mercado.daoImpl.EntradaDaoImpl;
import br.com.mercado.entity.Entrada;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.exception.IdNotFoundException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@ViewScoped
public class ListaEntradaBean {
	private List<Entrada> lista;
    private Entrada entrada;
	private EntradaDAO dao;
	private int cdBarra;
	
	
	@PostConstruct
	public void init(){
		dao = new EntradaDaoImpl(EMFactorySingleton.getInstance().createEntityManager());
		entrada  = new Entrada();
		lista = dao.listarEntrada();
	}
	
	public void excluir(){
		MensageView m = new MensageView();
		try {
			
			lista.remove(entrada);
			dao.delete(entrada.getCdEntrada());
			dao.alterarEstoque(entrada.getProduto().getCdProduto(), entrada.getQtCompra());
			m.info("Excluido com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			m.error("Erro ao Excluir");
		}
		
	}
	
	public void buscar(){
		lista = dao.buscarEntrada(dao.buscaCodigo(cdBarra));
	}
	public List<Entrada> getLista() {
		return lista;
	}

	public void setLista(List<Entrada> lista) {
		this.lista = lista;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	public int getCdBarra() {
		return cdBarra;
	}

	public void setCdBarra(int cdBarra) {
		this.cdBarra = cdBarra;
	}

	
	
	
	
}
