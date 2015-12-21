package br.com.mercado.bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.mercado.dao.ProdutoDAO;
import br.com.mercado.dao.VendaDAO;
import br.com.mercado.daoImpl.ProdutoDaoImpl;
import br.com.mercado.daoImpl.VendaDaoImpl;
import br.com.mercado.entity.ItemVenda;
import br.com.mercado.entity.Mais;
import br.com.mercado.entity.Produto;
import br.com.mercado.entity.Venda;
import br.com.mercado.exception.DBCommitException;
import br.com.mercado.singleton.EMFactorySingleton;


@ManagedBean
@ViewScoped
public class VendaBean {

	
	private Produto produto;

	private ProdutoDAO dao;

	private List<Produto> lista;
	
	private long codigo;

	private ItemVenda item;

	private Mais m;

	private Venda venda;

	public VendaDAO vDao;

	private int cd;

	private int qtd;

	private double total;

	private double totItem;

	
	@PostConstruct
	private void init() {

		EntityManager em = EMFactorySingleton.getInstance().createEntityManager();

		vDao = new VendaDaoImpl(em);
		dao = new ProdutoDaoImpl(em);
		produto = new Produto();
		venda = new Venda();
		venda.setDataVenda(Calendar.getInstance());

	}

	
	List<Mais> listagem = new ArrayList<Mais>();
	List<ItemVenda> itens = new ArrayList<ItemVenda>();

	MensageView ma = new MensageView();

	
	public void somar() {

		if (cd == 0 || qtd == 0 || produto.getPreco() == 0) {
			ma.error("Código do Produto ou Quantidade ou Total igual a zero");
		} else {

			Produto p = new Produto();
			long codigo = vDao.vendaBuscarBarra(cd);

			p = dao.findById((int) codigo);

			total += (qtd * produto.getPreco());
			totItem = (qtd * produto.getPreco());

			m = new Mais();

			m.setTotal(totItem);
			m.setQuantidade(qtd);
			m.setNome(produto.getNmProduto());
			listagem.add(m);

			item = new ItemVenda();

			item.setPrecoItem(totItem);
			item.setProduto(p);
			item.setQtItem(qtd);
			item.setVenda(venda);
			itens.add(item);

			produto.setNmProduto("");
			produto.setDescricao("");
			produto.setPreco(0);
			cd = 0;
			qtd = 0;
		}
	}

	
	public void buscar() {

		lista = vDao.nomePreco(cd);
		for (Produto p : lista) {
			produto.setNmProduto(p.getNmProduto());
			produto.setPreco(p.getPreco());
			produto.setDescricao(p.getDescricao());

		}

	}

	
	public void vender() {
		if (total == 0) {
			ma.error("Total da venda igual a zero,compra não efetuada");
		} else {
			venda.setTotal(total);
			venda.setItensVenda(itens);

			for (ItemVenda i : itens) {
				vDao.baixaEstoque(i.getProduto().getCdProduto(), i.getQtItem());
			}

			try {
				vDao.insert(venda);
				ma.info("Venda Cadastrada com sucesso");
			} catch (DBCommitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			total = venda.getTotal();
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

	
	public Venda getVenda() {
		return venda;
	}

	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	
	public List<ItemVenda> getI() {
		return itens;
	}

	
	public void setI(List<ItemVenda> i) {
		this.itens = i;
	}

	
	public double getTot() {
		return totItem;
	}

	
	public void setTot(double tot) {
		this.totItem = tot;
	}

	
	public List<Mais> getListagem() {
		return listagem;
	}

	
	public void setListagem(List<Mais> listagem) {
		this.listagem = listagem;
	}

	
	public double getTotItem() {
		return totItem;
	}

	
	public void setTotItem(double totItem) {
		this.totItem = totItem;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	public ItemVenda getItem() {
		return item;
	}

	public void setItem(ItemVenda item) {
		this.item = item;
	}

	public Mais getM() {
		return m;
	}

	public void setM(Mais m) {
		this.m = m;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

}
