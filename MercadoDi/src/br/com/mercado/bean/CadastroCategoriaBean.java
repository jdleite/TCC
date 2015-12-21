package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.com.mercado.daoImpl.CategoriaDaoImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class CadastroCategoriaBean {

	
	private CategoriaDaoImpl dao;

	
	private Categoria categoria;

	
	@PostConstruct
	private void init() {

		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		dao = new CategoriaDaoImpl(em);
		categoria = new Categoria();
	}


	public void cadastrar() {

		MensageView m = new MensageView();
		if(categoria.getTipo().equalsIgnoreCase("selecione")|| categoria.getUnidade().equalsIgnoreCase("selecione")){

			m.error("Selecione n�o � um tipo ou unidade V�lido");
		}else{
			
		
		
		try {
			dao.insert(getCategoria());
			m.info("Cadastrado com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
			m.error("Erro ao Cadastrar");
		}
		}
	}

	
	public Categoria getCategoria() {
		return categoria;
	}

	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
