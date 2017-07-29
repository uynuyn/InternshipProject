package com.minimalism.shop.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class UserType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3147908747431684163L;

	private String createUser;
	
	private Date createDate;

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
