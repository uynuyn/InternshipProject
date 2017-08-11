package com.minimalism.shop.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.base.Common;
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
		if (!choose.contains(id)) {
			choose.add(id);
		}
		if (choose.size() > 3) {
			choose.remove(0);
		}
		relatedProduct(choose, model);
		model.addAttribute("groupProduct", groupProduct);
		return "common/products/single";
	}
	public List<GroupProduct> removeDuplicate(List<GroupProduct> arrList)
	{
	    Set<GroupProduct> h = new HashSet<>(arrList);
	    arrList.clear();
	    arrList.addAll(h);
	   
	    return arrList;
	                   
	}

	public void relatedProduct(List<Integer> id, Model model) {
		List<GroupProduct> groupProducts = new ArrayList<GroupProduct>();
		List<AprioriList> list = aprioriService.aprioriLists();
		for (AprioriList aprioriList : list) {
			if (aprioriList.getVetrai().equals(id)) {
				for (int i = 0; i < aprioriList.getVephai().size(); i++) {
					GroupProduct groupProduct = groupProductService.findProductbyId(aprioriList.getVephai().get(i));
					if (!groupProducts.contains(groupProduct)) {
						System.out.println("true-------------------------------2");
						groupProducts.add(groupProduct);
					}
				}
			}

			if (Common.checkListNullandBlank(groupProducts)) {

				for (int k = 0; k < aprioriList.getVetrai().size(); k++) {
					if (aprioriList.getVetrai().get(k).equals(id.get(id.size() - 1))) {
						for (int i = 0; i < aprioriList.getVephai().size(); i++) {
							GroupProduct groupProduct = groupProductService
									.findProductbyId(aprioriList.getVephai().get(i));
							if (!groupProducts.contains(groupProduct)) {
								System.out.println("true-------------------------------1");
								groupProducts.add(groupProduct);
							}
						}
					}

				}
			}
		}
		List<GroupProduct> groupProducts1 = removeDuplicate(groupProducts);
		model.addAttribute("relatedProduct", groupProducts1);
	}

}
