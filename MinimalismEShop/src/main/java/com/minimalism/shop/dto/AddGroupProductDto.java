package com.minimalism.shop.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class AddGroupProductDto {
	private int id;
	private String name;
	private String description;
	private Integer size;
	private Integer qty;
	private String imge;
	private CommonsMultipartFile[] image;
	private Integer price;
	private Integer idCategory;
	private String isSpecial;
	private String isLastest;
	private Integer department;
	private boolean edit = true;
	
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public CommonsMultipartFile[] getImage() {
		return image;
	}
	public void setImage(CommonsMultipartFile[] image) {
		this.image = image;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}
	public String getIsSpecial() {
		return isSpecial;
	}
	public void setIsSpecial(String isSpecial) {
		this.isSpecial = isSpecial;
	}
	public String getIsLastest() {
		return isLastest;
	}
	public void setIsLastest(String isLastest) {
		this.isLastest = isLastest;
	}
	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	public String getImge() {
		return imge;
	}
	public void setImge(String imge) {
		this.imge = imge;
	}
	
}
