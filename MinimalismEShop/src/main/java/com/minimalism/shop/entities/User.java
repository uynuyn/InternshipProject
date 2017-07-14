package com.minimalism.shop.entities;
// Generated Jul 14, 2017 8:54:07 PM by Hibernate Tools 4.3.5.Final

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

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "User", schema = "dbo", catalog = "MinimalismShop")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 744194328286950154L;
	private Integer id;
	private Role role;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String firstname;
	private String lastname;
	private Integer point;
	private List<Order> orders = new ArrayList<>();
	private List<ImportStore> importStores = new ArrayList<>();

	public User() {
	}

	public User(Role role, String username, String email, String phone, String firstname) {
		this.role = role;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.firstname = firstname;
	}

	public User(Role role, String username, String password, String email, String phone,
			String firstname, String lastname, Integer point, List<Order> orders,
			List<ImportStore> importStores) {
		this.role = role;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.firstname = firstname;
		this.lastname = lastname;
		this.point = point;
		this.orders = orders;
		this.importStores = importStores;
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
	@JoinColumn(name = "idRole", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "firstname", nullable = false)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname")
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "point")
	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public List<ImportStore> getImportStores() {
		return this.importStores;
	}

	public void setImportStores(List<ImportStore> importStores) {
		this.importStores = importStores;
	}

}