package com.minimalism.shop.dto;

import java.util.Date;
import java.util.List;

public class OrderProduct {
	private int id;
	private String name;
	private String phone;
	private boolean delivery;
	private String address;
	private Date date;
	private Double subtotal;
	private List<ProductDto> lstProduct;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDelivery() {
		return delivery;
	}
	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public List<ProductDto> getLstProduct() {
		return lstProduct;
	}
	public void setLstProduct(List<ProductDto> lstProduct) {
		this.lstProduct = lstProduct;
	}
	

}
