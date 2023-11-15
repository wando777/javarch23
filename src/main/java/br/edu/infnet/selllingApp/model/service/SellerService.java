package br.edu.infnet.selllingApp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	public Seller listBySearch(String cpf) {
		return sellerRepository.findByCpf(cpf);
	}

	public void put(Seller seller) {
		Address address = addressClient.searchPostalCode(seller.getAddress().getCep());
		seller.setAddress(address);
		sellerRepository.save(seller);
	}

	public Collection<Seller> getSellerList() {
		return (Collection<Seller>) sellerRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	public void delete(Integer id) {
		sellerRepository.deleteById(id);
	}

	public long getQuantity() {
		return sellerRepository.count();
	}
}
