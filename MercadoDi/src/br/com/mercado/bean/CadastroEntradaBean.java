package br.com.mercado.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.com.mercado.dao.EntradaDAO;
import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.EntradaDaoImpl;
import br.com.mercado.daoImpl.ProdutoDaoImpl;
import br.com.mercado.entity.Entrada;
import br.com.mercado.entity.Produto;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;

// TODO: Auto-generated Javadoc

@ManagedBean
@RequestScoped
public class CadastroEntradaBean {

	
	private Entrada entrada;

	
	private EntradaDAO dao;

	
	private int cdProduto;

	
	private ProdutoDAO daoProd;

	
	private Produto produto;

	
	private int id;

	
	private int quantidade;

	
	@PostConstruct
	public void init() {

		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		dao = new EntradaDaoImpl(em);
		daoProd = new ProdutoDaoImpl(em);
		entrada = new Entrada();
		entrada.setDtCompra(Calendar.getInstance());
		entrada.setDtValidade(Calendar.getInstance());
		produto = new Produto();

	}

	
	public void cadastrar() {
		MensageView m = new MensageView();
		if (cdProduto == 0) {
			m.error("Produto Inválido");
		} else {

			try {
				double lucro = entrada.getPrecoVenda()
						- (entrada.getPrecoCompra() / entrada.getQtCompra());

				daoProd.alterarPreco(cdProduto, entrada.getPrecoVenda(), lucro);
				produto = daoProd.findById(cdProduto);
				entrada.setProduto(produto);
				dao.insert(entrada);
				dao.somar(cdProduto, entrada.getQtCompra());
				m.info("Cadastrado com Sucesso!");
			} catch (DBCommitException e) {
				e.printStackTrace();

				m.error("Cadastrado com Sucesso!");
			}
		}
	}

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public int getQuantidade() {
		return quantidade;
	}

	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	public Entrada getEntrada() {
		return entrada;
	}

	
	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	
	public int getCdProduto() {
		return cdProduto;
	}

	
	public void setCdProduto(int cdProduto) {
		this.cdProduto = cdProduto;
	}

	
	public Produto getProduto() {
		return produto;
	}

	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
