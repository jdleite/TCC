package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.ProdutoDAOImpl;
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
		dao = new ProdutoDAOImpl(EMFactorySingleton.getInstance()
				.createEntityManager());
		produto = new Produto();
	}

	public void alterar() {
		FacesMessage msg;

		try {
			dao.update(produto);
			msg = new FacesMessage("Alterado com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao Alterar");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
