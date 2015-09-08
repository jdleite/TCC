package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.mercado.dao.VendaDAO;
import br.com.mercado.daoImpl.VendaDAOImpl;
import br.com.mercado.entity.Produto;
import br.com.mercado.singleton.EMFactorySingleton;

@ManagedBean
@RequestScoped
public class VendaBean {
	private Produto produto;
	private List<Produto> lista;
	private List<Produto> produtos;
	public VendaDAO vDao;
	private int cd;
	private int qtd;

	private double total;

	@PostConstruct
	private void init() {
		vDao = new VendaDAOImpl(EMFactorySingleton.getInstance()
				.createEntityManager());
		produto = new Produto();
	}

	public void somar() {
		buscar();
		total += (qtd * produto.getPreco());

		qtd = 0;
		cd = 0;
		produto.setNmProduto(null);
		produto.setPreco(0);

		
	}

	public void buscar() {

		lista = vDao.nomePreco(cd);

		for (Produto p : lista) {
			produto.setNmProduto(p.getNmProduto());
			produto.setPreco(p.getPreco());
			
			

		}
	}

	public int getCd() {
		return cd;
	}

	public void setCd(int cd) {
		this.cd = cd;
	}

	public List<Produto> getLista() {
		return lista;
	}

	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
