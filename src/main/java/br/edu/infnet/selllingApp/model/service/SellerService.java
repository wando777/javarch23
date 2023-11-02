package br.edu.infnet.selllingApp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.selllingApp.model.domain.Seller;
import br.edu.infnet.selllingApp.model.repository.ISellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private ISellerRepository sellerRepository;

//	private Map<String, Seller> sellerMap = new HashMap<String, Seller>();

	public void put(Seller seller) {
//		sellerMap.put(seller.getCpf(), seller);
		sellerRepository.save(seller);
	}

	public Collection<Seller> getSellerList() {
//		return sellerMap.values();
		return (Collection<Seller>) sellerRepository.findAll();
	}
	
	public long getQuantity() {
		return sellerRepository.count();
	}
}
