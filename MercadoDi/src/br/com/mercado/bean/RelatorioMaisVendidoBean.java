package br.com.mercado.bean;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.dao.VendaDAO;
import br.com.mercado.daoImpl.ProdutoDaoImpl;
import br.com.mercado.daoImpl.VendaDaoImpl;
import br.com.mercado.entity.Produto;
import br.com.mercado.singleton.EMFactorySingleton;


@ManagedBean
@ViewScoped
public class RelatorioMaisVendidoBean {

	
	private BarChartModel grafico;

	
	private ProdutoDAO dao;

	
	private VendaDAO vDao;

	
	private Produto produto;

	
	@PostConstruct
	public void init() {

		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		dao = new ProdutoDaoImpl(em);
		vDao = new VendaDaoImpl(em);
		produto = new Produto();

		grafico = new BarChartModel();

		ChartSeries produtos = new ChartSeries();

		for (BigDecimal i : vDao.maisVendido()) {

			int id = Integer.valueOf(i.toString());

			produto = dao.findById(id);

			long quantidade = vDao.maisVendidos(id);

			produtos.set(produto.getNmProduto(), quantidade);
		}

		grafico.addSeries(produtos);

	}

	
	public BarChartModel getGrafico() {
		return grafico;
	}

	
	public Produto getProduto() {
		return produto;
	}

	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
