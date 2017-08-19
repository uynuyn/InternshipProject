package com.minimalism.shop.dto;

import org.codehaus.jackson.map.annotate.JsonView;

import com.minimalism.shop.jsonview.Views;

public class ProductDto {
	private Integer id;

	private String name;
	
	private String category;

	private int quantity;

	private int price;

	private int discount;

	private String imgPath;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	@JsonView(Views.Public.class)
	public Double getTotal(){
		return (double) (price*quantity); 
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
