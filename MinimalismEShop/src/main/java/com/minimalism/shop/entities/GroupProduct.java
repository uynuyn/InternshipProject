package com.minimalism.shop.entities;

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
 * GroupProduct
 * @author thucu
 */
@Entity
@Table(name = "`GroupProduct`", schema = "dbo", catalog = "MinimalismShop")
public class GroupProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7012525422847302103L;
	private Integer id;
	private Category category;
	private String name;
	private String description;
	private Integer size;
	private boolean endProduct;
	private String imge;
	private int price;
	private Boolean isSpecial;
	private Boolean isLastest;
	@Transient
	private List<PromotionDetail> promotionDetails = new ArrayList<>();
	@Transient
	private List<Product> products = new ArrayList<>();
	@Transient
	private List<ImportDetail> importDetails = new ArrayList<>();

	public GroupProduct() {
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
	@JoinColumn(name = "idCategory")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "size")
	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Column(name = "endProduct", nullable = false)
	public boolean isEndProduct() {
		return endProduct;
	}

	public void setEndProduct(boolean endProduct) {
		this.endProduct = endProduct;
	}

	@Column(name = "imge")
	public String getImge() {
		return this.imge;
	}

	public void setImge(String imge) {
		this.imge = imge;
	}

	@Column(name = "price", nullable = false)
	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name = "isSpecial")
	public Boolean getIsSpecial() {
		return this.isSpecial;
	}

	public void setIsSpecial(Boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	@Column(name = "isLastest")
	public Boolean getIsLastest() {
		return this.isLastest;
	}

	public void setIsLastest(Boolean isLastest) {
		this.isLastest = isLastest;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupProduct")
	public List<PromotionDetail> getPromotionDetails() {
		return this.promotionDetails;
	}

	public void setPromotionDetails(List<PromotionDetail> promotionDetails) {
		this.promotionDetails = promotionDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupProduct")
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupProduct")
	public List<ImportDetail> getImportDetails() {
		return this.importDetails;
	}

	public void setImportDetails(List<ImportDetail> importDetails) {
		this.importDetails = importDetails;
	}

}
