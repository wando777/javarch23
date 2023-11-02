package br.edu.infnet.selllingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.selllingApp.model.service.ClothingService;
import br.edu.infnet.selllingApp.model.service.ProductService;
import br.edu.infnet.selllingApp.model.service.SellerService;
import br.edu.infnet.selllingApp.model.service.TissueService;

@Controller
public class AppController {

	@Autowired
	private SellerService sellerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ClothingService clothingService;
	@Autowired
	private TissueService tissueService;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping(value = "/")
	public String showHome(Model model) {
		model.addAttribute("countSeller", sellerService.getQuantity());
		model.addAttribute("countProduct", productService.getQuantity());
		model.addAttribute("countClothing", clothingService.getQuantity());
		model.addAttribute("countTissue", tissueService.getQuantity());
		return "home";
	}

	@GetMapping(value = "/sellers")
	public String listSellers(Model model) {
		model.addAttribute("title", "Sellers:");
		model.addAttribute("collection", sellerService.getSellerList());
		return showHome(model);
	}

	@GetMapping(value = "/products")
	public String listProducts(Model model) {
		model.addAttribute("title", "Products:");
		model.addAttribute("collection", productService.getProductList());
		return showHome(model);
	}

	@GetMapping(value = "/clothes")
	public String listClothes(Model model) {
		model.addAttribute("title", "Clothes:");
		model.addAttribute("collection", clothingService.getClothingList());
		return showHome(model);
	}

	@GetMapping(value = "/tissues")
	public String listTissues(Model model) {
		model.addAttribute("title", "Tissues:");
		model.addAttribute("collection", tissueService.getTissueList());
		return showHome(model);
	}
}
