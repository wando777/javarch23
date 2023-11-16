package br.edu.infnet.selllingApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.selllingApp.model.domain.SellingDetails;

@Controller
public class SellingDetailsController {

	@PostMapping(value = "/selling_details/add")
	public String insert(SellingDetails sellingDetails) {
		System.out.println(sellingDetails.getField() + "-" + sellingDetails.getDescription());
		return "redirect:/";
	}
}
