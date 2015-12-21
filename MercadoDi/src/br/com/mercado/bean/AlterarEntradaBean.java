package br.com.mercado.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.com.mercado.dao.EntradaDAO;
import br.com.mercado.daoImpl.EntradaDaoImpl;
import br.com.mercado.entity.Entrada;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

// TODO: Auto-generated Javadoc

@ManagedBean
@RequestScoped
public class AlterarEntradaBean {

	
	private Entrada entrada;

	
	private EntradaDAO dao;
 
	@PostConstruct
	private void init() {

		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		dao = new EntradaDaoImpl(em);
		entrada = new Entrada();

		entrada.setDtCompra(Calendar.getInstance());
		entrada.setDtValidade(Calendar.getInstance());
	}

	
	public void alterar() {
		MensageView m = new MensageView();
		try {
			dao.update(entrada);
			m.info("Atualizado com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
			m.error("Erro ao Atualizar");

		}

	}

	
	public Entrada getEntrada() {
		return entrada;
	}

	
	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

}
