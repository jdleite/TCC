package br.com.mercado.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
// TODO: Auto-generated Javadoc


@Entity
@SequenceGenerator(name = "seqVenda", sequenceName = "SEQ_VENDA", allocationSize = 1)
@Table(name = "TB_DI_VENDA")

public class Venda implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVenda")
	@Column(name = "CD_VENDA")
	private long cdVenda;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_VENDA",nullable = false)
	private Calendar dataVenda;
	
	
	@Column(name="SUB_TOTAL",length=10,nullable=false)
	private double total;
	
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<ItemVenda> itensVenda;
	
	
	
	
	
	public Venda(){
		

		itensVenda = new ArrayList<ItemVenda>();
		
	}
	
	
	public void addItemVenda(ItemVenda itens){
		itensVenda.add(itens);
	}
	
	
	public long getCdVenda() {
		return cdVenda;
	}
	
	
	public void setCdVenda(long cdVenda) {
		this.cdVenda = cdVenda;
	}
	
	
	public Calendar getDataVenda() {
		return dataVenda;
	}
	
	
	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	
	public double getTotal() {
		return total;
	}
	
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}
	
	
	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

}
