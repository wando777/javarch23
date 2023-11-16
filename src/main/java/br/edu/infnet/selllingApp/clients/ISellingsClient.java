package br.edu.infnet.selllingApp.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.selllingApp.model.domain.SellingDetails;

@FeignClient(url = "http://localhost:8081/api/sellings", name = "sellingsClient")
public interface ISellingsClient {

	@GetMapping(value = "/details")
	public List<SellingDetails> getDetails();
}
