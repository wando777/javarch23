package br.edu.infnet.selllingApp.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.selllingApp.model.domain.Seller;

@Repository
public interface ISellerRepository extends CrudRepository<Seller, Integer> {

}
