package br.edu.infnet.selllingApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.selllingApp.model.domain.Seller;

@Service
public class SellerService {

	private Map<String, Seller> sellerMap = new HashMap<String, Seller>();

	public void put(Seller seller) {
		sellerMap.put(seller.getCpf(), seller);
	}

	public Collection<Seller> getSellerList() {
		return sellerMap.values();
	}
}
