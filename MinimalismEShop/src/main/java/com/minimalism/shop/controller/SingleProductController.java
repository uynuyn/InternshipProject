package com.minimalism.shop.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

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
	public String product(Model model, @PathVariable("id") int id, HttpSession session) {
		session.removeAttribute("seen");
		GroupProduct groupProduct = groupProductService.findProductbyId(id);
		Set<GroupProduct> seen = new HashSet<>();

		for (int j = 0; j < choose.size(); j++) {
			if (id == choose.get(j)) {
				choose.remove(j);
			}
		}
		if (choose.size() > 2) {
			choose.remove(0);

		}

		choose.add(id);
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
			if (count == choose.size()) {
				for (int i = 0; i < aprioriList.getVephai().size(); i++) {
					integers.add(aprioriList.getVephai().get(i));
				}

			}
		}
		if (integers.isEmpty() || integers.size() == 0) {
			for (AprioriList aprioriList : list) {
				if (aprioriList.getVetrai().size() == 1) {

					if (aprioriList.getVetrai().get(0).equals(choose.get(choose.size() - 1))) {
						for (int i = 0; i < aprioriList.getVephai().size(); i++) {
							integers.add(aprioriList.getVephai().get(i));
						}
					}
				}
			}
		}
		Iterator<Integer> iterator = integers.iterator();
		while (iterator.hasNext()) {
			int i = iterator.next();
			if (id != i) {
				GroupProduct groupProducta = groupProductService.findProductbyId(i);
				groupProducts.add(groupProducta);
			}
		}

		model.addAttribute("relatedProduct", groupProducts);
		session.setAttribute("seen", seen);
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
