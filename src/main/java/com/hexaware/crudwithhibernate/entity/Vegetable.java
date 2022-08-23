package com.hexaware.crudwithhibernate.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity(name="vegetable")
@Table(name = "vegetable_info")
@NamedQueries(
	{
			@NamedQuery(
					name="searchVegetableByName",
					query = "from vegetable v where v.vegName = :name"
					)
		})
public class Vegetable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vegetableid")
	private Long vegId;
	
	@Column(name = "vegetablename")
	@Size(min=3)
	private String vegName;
	
	@Column(name = "vegetableprice")
	private Long vegPrice;
	
	

	public Vegetable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vegetable(String vegName, Long vegPrice) {
		super();
		this.vegName = vegName;
		this.vegPrice = vegPrice;
		
	}

	public Vegetable(Long vegId, String vegName, Long vegPrice) {
		super();
		this.vegId = vegId;
		this.vegName = vegName;
		this.vegPrice = vegPrice;
		
	}

	public Long getVegId() {
		return vegId;
	}

	public void setVegId(Long vegId) {
		this.vegId = vegId;
	}

	public String getVegName() {
		return vegName;
	}

	public void setVegName(String vegName) {
		this.vegName = vegName;
	}

	public Long getVegPrice() {
		return vegPrice;
	}

	public void setVegPrice(Long vegPrice) {
		this.vegPrice = vegPrice;
	}

	@Override
	public String toString() {
		return "Vegetable [vegId=" + vegId + ", vegName=" + vegName + ", vegPrice=" + vegPrice + "]";
	}

	

	
}
