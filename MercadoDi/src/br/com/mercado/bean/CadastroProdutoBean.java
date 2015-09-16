package br.com.mercado.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.mercado.dao.CategoriaDAO;
import br.com.mercado.dao.FornecedorDAO;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.CategoriaDaoImpl;
import br.com.mercado.daoImpl.FornecedorDaoImpl;
import br.com.mercado.daoImpl.ProdutoDaoImpl;
import br.com.mercado.entity.Categoria;
import br.com.mercado.entity.Fornecedor;
import br.com.mercado.entity.Produto;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class CadastroProdutoBean {

	private Produto produto;
	private Categoria categoria;
	private Fornecedor fornecedor;
	private FornecedorDAO daoFor;
	private ProdutoDAO dao;
	private CategoriaDAO daoCat;
	private int cdCategoria;
	private int cdFornecedor;
	private int c;

	@PostConstruct
	private void init() {
		dao = new ProdutoDaoImpl(EMFactorySingleton.getInstance()
				.createEntityManager());
		daoCat = new CategoriaDaoImpl(EMFactorySingleton.getInstance()
				.createEntityManager());
		daoFor = new FornecedorDaoImpl(EMFactorySingleton.getInstance()
				.createEntityManager());
		categoria = new Categoria();
		produto = new Produto();
		

		

	}

	public void cadastrar() {
		MensageView m = new MensageView();
		
		boolean a = dao.encotrarCodigoBarra(produto.getCdBarra());
		if(a == false){
		try {
			categoria = daoCat.findById(cdCategoria);
			fornecedor = daoFor.findById(cdFornecedor);
			produto.setFornecedor(fornecedor);
			produto.setCategoria(categoria);
			dao.insert(produto);
			m.info("Cadastrado com Sucesso");
		} catch (DBCommitException e) {
			e.printStackTrace();
			m.error("Erro ao Cadastrar!");
		}
		}else{
			
			m.error("Código de Barra já Cadastrado");
		}
	
	}

	public void encontrarCodigoBarra() {
		FacesMessage msg;

		boolean a = dao.encotrarCodigoBarra(produto.getCdBarra());

		if (a == false) {

			msg = new FacesMessage("Códido de Barra Não Cadastrado!");

		} else {
			msg = new FacesMessage("Código de Barra Já Cadastrado!");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getCdCategoria() {
		return cdCategoria;
	}

	public void setCdCategoria(int cdCategoria) {
		this.cdCategoria = cdCategoria;
	}

	public int getCdFornecedor() {
		return cdFornecedor;
	}

	public void setCdFornecedor(int cdFornecedor) {
		this.cdFornecedor = cdFornecedor;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	
	
	

}
