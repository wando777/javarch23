package br.edu.infnet.selllingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.selllingApp.model.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private AppController appController;

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/product/{id}/delete")
	public String delete(@PathVariable Integer id) {
		productService.delete(id);
		return "redirect:/products";
	}

	@GetMapping(value = "/products")
	public String listProducts(Model model) {
		
		model.addAttribute("route", "product");
		model.addAttribute("title", "Products:");
		model.addAttribute("collection", productService.getProductList());
		return appController.showHome(model);
	}

}
