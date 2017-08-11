package com.minimalism.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.minimalism.shop.cmn.service.impl.AprioriServiceImpl;

@Controller
public class BlankController {

	@Autowired private AprioriServiceImpl aprioriService;
	
	@RequestMapping(value = "/blank", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		aprioriService.findAllList();
		return "blank";
	}
}
