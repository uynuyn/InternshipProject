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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author thucu
 */
@Entity
@Table(name = "`Department`", schema = "dbo", catalog = "MinimalismShop")
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8924509690829550577L;
	private Integer id;
	private String name;
	private String code;
	@Transient
	private List<Category> categories = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "code")
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
