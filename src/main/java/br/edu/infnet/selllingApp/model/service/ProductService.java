package br.edu.infnet.selllingApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.selllingApp.model.domain.Product;

@Service
public class ProductService {

	private Map<Integer, Product> productMap = new HashMap<Integer, Product>();

	public void put(Product product) {
		productMap.put(product.getId(), product);
	}

	public Collection<Product> getProductList() {
		return productMap.values();
	}
}
