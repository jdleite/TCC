package br.com.mercado.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.daoImpl.ProdutoDaoImpl;
import br.com.mercado.entity.Produto;
import br.com.mercado.singleton.EMFactorySingleton;

// TODO: Auto-generated Javadoc

@ManagedBean
@ViewScoped
public class RelatorioEstoqueBean {

	
	private BarChartModel grafico;

	
	private ProdutoDAO dao;

	
	@PostConstruct
	public void init() {

		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();
		dao = new ProdutoDaoImpl(em);
		grafico = new BarChartModel();

		ChartSeries produtos = new ChartSeries();

		List<Produto> lista = dao.listarProduto();
		for (Produto i : lista) {
			produtos.set(i.getNmProduto(), i.getEstoque());
		}

		grafico.addSeries(produtos);

	}

	
	public BarChartModel getGrafico() {
		return grafico;
	}

}
