package br.edu.infnet.selllingApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.selllingApp.model.domain.SellingDetails;
import br.edu.infnet.selllingApp.model.service.SellingService;

@Controller
public class SellingDetailsController {

	private SellingService sellingService;

	@PostMapping(value = "/selling_details/add")
	public String insert(SellingDetails sellingDetails) {
//		System.out.println(sellingDetails.getField() + "-" + sellingDetails.getDescription());
		SellingDetails res = sellingService.sendDetails(sellingDetails);
		System.out.println("RESPONSE FROM SELLING DETAILS: " + res);
		return "redirect:/";
	}
}
