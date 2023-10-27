package br.edu.infnet.selllingApp.model.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.selllingApp.model.domain.Product;

@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {

	@Query("from Product p where p.seller.id = :sellerId")
	Collection<Product> getProductList(Integer sellerId);
}
