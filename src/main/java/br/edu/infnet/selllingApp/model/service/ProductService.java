package br.edu.infnet.selllingApp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.selllingApp.model.domain.Product;
import br.edu.infnet.selllingApp.model.domain.Seller;
import br.edu.infnet.selllingApp.model.repository.IProductRepository;

@Service
public class ProductService {

	@Autowired
	private IProductRepository productRepository;

//	private Map<Integer, Product> productMap = new HashMap<Integer, Product>();

	public void put(Product product) {
//		productMap.put(product.getId(), product);
		productRepository.save(product);
	}

	public Collection<Product> getProductList() {
//		return productMap.values();
		return (Collection<Product>) productRepository.findAll();
	}
	
	public Collection<Product> getProductList(Seller seller) {
		return (Collection<Product>) productRepository.getProductList(seller.getId());
	}
	
	public long getQuantity() {
		return productRepository.count();
	}
}
