package br.edu.infnet.selllingApp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.selllingApp.clients.ISellingsClient;

@Service
public class SellingService {
	
	@Autowired
	private ISellingsClient sellingsClient;
	
	public List<String> getSellingDetails() {
		return sellingsClient.getDetails();
	}

}
