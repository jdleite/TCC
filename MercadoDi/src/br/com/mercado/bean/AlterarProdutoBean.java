package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.ProdutoDaoImpl;
import br.com.mercado.entity.Produto;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

// TODO: Auto-generated Javadoc

@ManagedBean
@RequestScoped
public class AlterarProdutoBean {

	
	private Produto produto;

	
	private ProdutoDAO dao;

	
	@PostConstruct
	public void init() {

		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		dao = new ProdutoDaoImpl(em);
		produto = new Produto();
		
	
		

	}

	
	public void alterar() {
		MensageView m = new MensageView();

		try {
			dao.update(produto);
			m.info("Alterado com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
			m.error("Erro ao Alterar");
		}

	}


	public Produto getProduto() {
		return produto;
	}

	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
