package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.daoImpl.CategoriaDaoImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class AlterarCategoriaBean {

	private CategoriaDAO dao;

	private Categoria categoria;

	@PostConstruct
	private void init() {
		categoria = new Categoria();
		dao = new CategoriaDaoImpl(EMFactorySingleton.getInstance()
				.createEntityManager());

		

	}

	public void alterar() {
		MensageView m = new MensageView();

		try {
			dao.update(categoria);
			m.info("Atualizado com Sucesso!");
		} catch (DBCommitException e) {
			m.error("Erro ao Atualizar");
			e.printStackTrace();
		}

	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
