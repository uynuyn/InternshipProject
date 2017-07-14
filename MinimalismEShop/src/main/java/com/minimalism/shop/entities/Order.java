package com.minimalism.shop.entities;
// Generated Jul 11, 2017 9:54:23 PM by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Order generated by hbm2java
 */
@Entity
@Table(name = "Order", schema = "dbo", catalog = "MinimalismShop")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3218023722523928603L;
	private Integer id;
	private User user;
	private String orderDate;
	private String deliveryDate;
	private int amount;
	private Boolean status;
	private String note;
	private String receiverName;
	private String address;
	@Transient
	private List<OrderDetail> orderDetails = new ArrayList<>();

	public Order() {
	}

	public Order(User user, String orderDate, int amount, String receiverName,
			String address) {
		this.user = user;
		this.orderDate = orderDate;
		this.amount = amount;
		this.receiverName = receiverName;
		this.address = address;
	}

	public Order(User user, String orderDate, String deliveryDate, int amount, Boolean status,
			String note, String receiverName, String address, List<OrderDetail> orderDetails) {
		this.user = user;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.amount = amount;
		this.status = status;
		this.note = note;
		this.receiverName = receiverName;
		this.address = address;
		this.orderDetails = orderDetails;
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
	@JoinColumn(name = "idUser", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "orderDate", nullable = false)
	public String getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "deliveryDate")
	public String getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Column(name = "amount", nullable = false)
	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column(name = "status")
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Column(name = "note")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "receiverName", nullable = false)
	public String getReceiverName() {
		return this.receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
