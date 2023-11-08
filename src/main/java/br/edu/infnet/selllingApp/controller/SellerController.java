package br.edu.infnet.selllingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.selllingApp.model.service.SellerService;

@Controller
public class SellerController {

	@Autowired
	private AppController appController;

	@Autowired
	private SellerService sellerService;

	@GetMapping(value = "/seller/{id}/delete")
	public String delete(@PathVariable Integer id) {
		sellerService.delete(id);
		return "redirect:/sellers";
	}

	@GetMapping(value = "/sellers")
	public String listSellers(Model model) {
		
		model.addAttribute("route", "seller");
		model.addAttribute("title", "Sellers:");
		model.addAttribute("collection", sellerService.getSellerList());
		return appController.showHome(model);
	}

}
