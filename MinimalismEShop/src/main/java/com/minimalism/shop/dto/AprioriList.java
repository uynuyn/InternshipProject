package com.minimalism.shop.dto;

import java.util.List;

public class AprioriList {

	/**
	 * 
	 */
	private List<Integer> vetrai;
	private List<Integer> vephai;
	private float support;

	public AprioriList() {
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

	public float getSupport() {
		return support;
	}

	public void setSupport(float support) {
		this.support = support;
	}
	
	
}
