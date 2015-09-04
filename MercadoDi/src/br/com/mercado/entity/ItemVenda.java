package br.com.mercado.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seqItem",sequenceName="SEQ_ITEM",allocationSize=1)
@Table(name="TB_DI_ITEM_VENDA")
public class ItemVenda implements Serializable{
	private static final long serialVersionUID = -4802321255610584965L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "seqItem")
	@Column(name="CD_ITEM")
	private int cdItem;
	@ManyToOne
	@JoinColumn(name = "CD_Produto")
	private Produto produto;
	@Column(name = "QT_ITEM",length=1000,nullable=true)
	private int qtItem;
	@Column(name="PRECO_ITEM",length=50,nullable=true)
	private double precoItem;
	
	public ItemVenda (){
		
	}
	public int getCdItem() {
		return cdItem;
	}
	public void setCdItem(int cdItem) {
		this.cdItem = cdItem;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getQtItem() {
		return qtItem;
	}
	public void setQtItem(int qtItem) {
		this.qtItem = qtItem;
	}
	public double getPrecoItem() {
		return precoItem;
	}
	public void setPrecoItem(double precoItem) {
		this.precoItem = precoItem;
	}
	
	
	
	
	
}
