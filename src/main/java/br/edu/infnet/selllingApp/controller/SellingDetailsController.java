package br.edu.infnet.selllingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.selllingApp.model.domain.SellingDetails;
import br.edu.infnet.selllingApp.model.service.SellingService;

@Controller
public class SellingDetailsController {

	@Autowired
	private SellingService sellingService;

	@PostMapping(value = "/selling_details/add")
	public String insert(SellingDetails sellingDetails) {
		System.out.println("INPUTS: " + sellingDetails.getField() + "-" + sellingDetails.getDescription());
		SellingDetails res = sellingService.sendDetails(sellingDetails);
		System.out.println("RESPONSE FROM SELLING DETAILS: " + res);
		return "redirect:/";
	}
}
