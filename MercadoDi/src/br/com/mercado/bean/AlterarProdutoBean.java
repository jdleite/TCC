package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.ProdutoDaoImpl;
import br.com.mercado.entity.Produto;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class AlterarProdutoBean {
	private Produto produto;
	private ProdutoDAO dao;

	@PostConstruct
	public void init() {
		dao = new ProdutoDaoImpl(EMFactorySingleton.getInstance()
				.createEntityManager());
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
