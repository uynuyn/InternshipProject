package com.minimalism.shop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author thucu
 */
@Entity
@Table(name = "Involve", schema = "dbo", catalog = "MinimalismShop")
public class Involve implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7012524030757954939L;
	private Integer id;
	private Order order;
	private GroupProduct groupProduct;
	private Integer year;
	
	public Involve() {
	}

	public Involve(Order order, GroupProduct groupProduct, Integer year) {
		this.order = order;
		this.groupProduct = groupProduct;
		this.year = year;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idOrder")
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idGroupProduct")
	public GroupProduct getGroupProduct() {
		return this.groupProduct;
	}

	public void setGroupProduct(GroupProduct groupProduct) {
		this.groupProduct = groupProduct;
	}
	
	@Column(name = "year")
	public Integer getYear() {
		return this.year;
	}

	public void setYear	(Integer year) {
		this.year = year;
	}

}
