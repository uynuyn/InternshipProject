package com.minimalism.shop.dto;

import java.util.List;

public class AprioriList {

	/**
	 * 
	 */
	private Integer id;
	private List<Integer> vetrai;
	private List<Integer> vephai;

	public AprioriList() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Integer> getVetrai() {
		return vetrai;
	}

	public void setVetrai(List<Integer> vetrai) {
		this.vetrai = vetrai;
	}

	public List<Integer> getVephai() {
		return vephai;
	}

	public void setVephai(List<Integer> vephai) {
		this.vephai = vephai;
	}
	
}
