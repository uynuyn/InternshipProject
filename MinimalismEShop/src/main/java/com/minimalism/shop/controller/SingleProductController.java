package com.minimalism.shop.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.service.impl.AprioriServiceImpl;
import com.minimalism.shop.cmn.service.impl.GroupProductServiceImpl;
import com.minimalism.shop.dto.AprioriList;
import com.minimalism.shop.entities.GroupProduct;

@Controller
@RequestMapping("/product")
public class SingleProductController {
	@Autowired
	private GroupProductServiceImpl groupProductService;

	List<Integer> choose = new ArrayList<>();

	@Autowired
	private AprioriServiceImpl aprioriService;

	@RequestMapping(value = "/single/{id}", method = RequestMethod.GET)
	public String product(Model model, @PathVariable("id") int id) {
		GroupProduct groupProduct = groupProductService.findProductbyId(id);
		Set<GroupProduct> seen = new HashSet<>();
		if (!choose.contains(id)) {
			choose.add(id);
		}
		if (choose.size() > 3) {
			choose.remove(0);
		}
		relatedProduct(choose, model);
		for (int i = 0; i < choose.size(); i++) {
			GroupProduct g = groupProductService.findProductbyId(choose.get(i));
			seen.add(g);
		}
		
		List<GroupProduct> groupProducts = new ArrayList<GroupProduct>();
		List<AprioriList> list = aprioriService.aprioriLists();
		Set<Integer> integers = new HashSet<>();
		for (AprioriList aprioriList : list) {
			int count = 0;
			boolean containsElement = false;
			for (int integer = 0; integer < choose.size(); integer++) {
				for (int i = 0; i < aprioriList.getVetrai().size(); i++) {
					if (aprioriList.getVetrai().get(i).equals(choose.get(integer))) {
						containsElement = true;
						count++;
						break;
					}
				}
				if (!containsElement) {
					break;
				}

			}
			if (count == aprioriList.getVephai().size()) {
				for (int i = 0; i < aprioriList.getVephai().size(); i++) {
					integers.add(aprioriList.getVephai().get(i));
				}
			}
			if (integers.size() == 0) {
				if (aprioriList.getVetrai().get(0).equals(choose.get(choose.size() - 1))) {
					for (int i = 0; i < aprioriList.getVephai().size(); i++) {
						integers.add(aprioriList.getVephai().get(i));

					}
				}

			}
		}
		Iterator<Integer> iterator = integers.iterator();
		while (iterator.hasNext()) {
			int i = iterator.next();
			GroupProduct groupProducta = groupProductService.findProductbyId(i);
			groupProducts.add(groupProducta);
		}

		model.addAttribute("relatedProduct", groupProducts);
		
		model.addAttribute("seen", seen);
		model.addAttribute("groupProduct", groupProduct);
		return "common/products/single";
	}

	public List<GroupProduct> removeDuplicate(List<GroupProduct> arrList) {
		Set<GroupProduct> h = new HashSet<>(arrList);
		arrList.clear();
		arrList.addAll(h);

		return arrList;

	}

	public void relatedProduct(List<Integer> id, Model model) {
		
	}

}
