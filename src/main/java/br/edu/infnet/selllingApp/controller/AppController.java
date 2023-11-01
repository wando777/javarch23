package br.edu.infnet.selllingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.selllingApp.model.service.SellerService;

@Controller
public class AppController {

	@Autowired
	private SellerService sellerService;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping(value = "/")
	public String showHome(Model model) {
		model.addAttribute("countSeller", sellerService.getSellerList().size());
		model.addAttribute("countProduct", 7);
		model.addAttribute("countClothing", 77);
		model.addAttribute("countTissue", 777);
		return "home";
	}
	
	@GetMapping(value = "/sellers")
	public String listSellers(Model model) {
		model.addAttribute("collection", sellerService.getSellerList());
		return showHome(model);
	}
}
