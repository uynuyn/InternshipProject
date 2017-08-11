package com.minimalism.shop.dto;

import java.util.HashSet;
import java.util.Set;

public class Tuple {
	public Set<Integer> itemset;
	public int support;
	
	public Tuple() {
		itemset = new HashSet<Integer>();
		support = -1;
	}
	
	Tuple(Set<Integer> s) {
		itemset = s;
		support = -1;
	}
	
	public Tuple(Set<Integer> s, int i) {
		itemset = s;
		support = i;
	}
}
