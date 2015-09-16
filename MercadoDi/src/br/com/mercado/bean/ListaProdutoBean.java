package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mercado.dao.EntradaDAO;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.EntradaDaoImpl;
import br.com.mercado.daoImpl.ProdutoDaoImpl;
import br.com.mercado.entity.Produto;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.exception.IdNotFoundException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@ViewScoped
public class ListaProdutoBean {

	private List<Produto> lista;
	private List<Produto> nome;
	public ProdutoDAO dao;
	private String nomeBusca;
	private Produto produto;
	private EntradaDAO eDao;

	@PostConstruct
	public void init() {
		dao = new ProdutoDaoImpl(EMFactorySingleton.getInstance()
				.createEntityManager());
		eDao = new EntradaDaoImpl(EMFactorySingleton.getInstance()
				.createEntityManager());

	  produto = new Produto();
	  
	  lista = dao.listarProduto();
	}
	

	public void excluir() {
		MensageView m = new MensageView();
		try {
			lista.remove(produto);
			eDao.deletar(produto.getCdProduto());
			dao.delete(produto.getCdProduto());

			m.info("Excluido com Sucesso!");
		} catch (DBCommitException e) {
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			m.error("Erro ao Excluir!");
		}

	}
	
	public void buscar(){
		lista = dao.buscarNomeProduto(nomeBusca);
	}
	
	
	public List<String> completarNome(String nome){
         
		return dao.autoCompletePorNome(nome);

	}

	public List<Produto> getLista() {
		return lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}

	public List<Produto> getNome() {
		return nome;
	}

	public void setNome(List<Produto> nome) {
		this.nome = nome;
	}

	public String getNomeBusca() {
		return nomeBusca;
	}

	public void setNomeBusca(String nomeBusca) {
		this.nomeBusca = nomeBusca;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
