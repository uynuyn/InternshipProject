package com.minimalism.shop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
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
	private Integer idType;
	private Integer idInvolve;

	public Involve() {
	}

	public Involve(Integer idType, Integer idInvolve) {
		this.idType = idType;
		this.idInvolve = idInvolve;
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

	@Column(name = "idType")
	public Integer getIdType() {
		return this.idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	@Column(name = "idInvolve")
	public Integer getIdInvolve() {
		return this.idInvolve;
	}

	public void setIdInvolve(Integer idInvolve) {
		this.idInvolve = idInvolve;
	}

}
