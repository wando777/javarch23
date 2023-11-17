package br.edu.infnet.selllingApp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.selllingApp.clients.ISellingsClient;
import br.edu.infnet.selllingApp.model.domain.SellingDetails;

@Service
public class SellingService {

	@Autowired
	private ISellingsClient sellingsClient;

	public List<SellingDetails> getSellingDetails() {
		return sellingsClient.getDetails();
	}

	public SellingDetails sendDetails(SellingDetails sellingDetails) {
		return sellingsClient.sendDetails(sellingDetails);
	}
}
