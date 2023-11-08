package br.edu.infnet.selllingApp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.selllingApp.clients.IAddressClient;
import br.edu.infnet.selllingApp.model.domain.Address;
import br.edu.infnet.selllingApp.model.domain.Seller;
import br.edu.infnet.selllingApp.model.repository.ISellerRepository;

@Service
public class SellerService {

	@Autowired
	private ISellerRepository sellerRepository;
	
	@Autowired
	private IAddressClient addressClient;

//	private Map<String, Seller> sellerMap = new HashMap<String, Seller>();

	public void put(Seller seller) {
//		sellerMap.put(seller.getCpf(), seller);
		Address address = addressClient.searchPostalCode(seller.getAddress().getCep());
		seller.setAddress(address);
		sellerRepository.save(seller);
	}

	public Collection<Seller> getSellerList() {
//		return sellerMap.values();
		return (Collection<Seller>) sellerRepository.findAll();
	}

	public void delete(Integer id) {
		sellerRepository.deleteById(id);
	}

	public long getQuantity() {
		return sellerRepository.count();
	}
}
