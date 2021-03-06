package com.minimalism.shop.entities;
// Generated Jul 11, 2017 9:54:23 PM by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
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
 * ImportDetail generated by hbm2java
 */
@Entity
@Table(name = "`ImportDetail`", schema = "dbo", catalog = "MinimalismShop")
public class ImportDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6318410351231310366L;
	private Integer id;
	private GroupProduct groupProduct;
	private ImportStore importStore;
	private int price;
	private int quantity;
	private String note;

	public ImportDetail() {
	}

	public ImportDetail(GroupProduct groupProduct, ImportStore importStore, int price, int quantity) {
		this.groupProduct = groupProduct;
		this.importStore = importStore;
		this.price = price;
		this.quantity = quantity;
	}

	public ImportDetail(GroupProduct groupProduct, ImportStore importStore, int price, int quantity,
			String note) {
		this.groupProduct = groupProduct;
		this.importStore = importStore;
		this.price = price;
		this.quantity = quantity;
		this.note = note;
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
	@JoinColumn(name = "idGroupProduct", nullable = false)
	public GroupProduct getGroupProduct() {
		return this.groupProduct;
	}

	public void setGroupProduct(GroupProduct groupProduct) {
		this.groupProduct = groupProduct;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idImportStore", nullable = false)
	public ImportStore getImportStore() {
		return this.importStore;
	}

	public void setImportStore(ImportStore importStore) {
		this.importStore = importStore;
	}

	@Column(name = "price", nullable = false)
	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "note")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
