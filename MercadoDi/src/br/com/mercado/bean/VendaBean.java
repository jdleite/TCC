package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.ProdutoDAOImpl;
import br.com.mercado.entity.Produto;
import br.com.mercado.singleton.EMFactorySingleton;
@ManagedBean
@RequestScoped
public class VendaBean {
	
	private Produto produto;
	private ProdutoDAO dao;
	private int cdProduto;
	
	
	
	@PostConstruct
	private void init(){
		dao = new ProdutoDAOImpl(EMFactorySingleton.getInstance().createEntityManager());
		
	   produto = new Produto();
		
	}
	
	
	private void buscarProduto(){
		produto = dao.findById(cdProduto);
		
		
	}



	public Produto getProduto() {
		return produto;
	}



	public void setProduto(Produto produto) {
		this.produto = produto;
	}



	public int getCdProduto() {
		return cdProduto;
	}



	public void setCdProduto(int cdProduto) {
		this.cdProduto = cdProduto;
	}
	
	

}
