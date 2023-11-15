package br.edu.infnet.selllingApp.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8081/api/sellings", name = "sellingsClient")
public interface ISellingsClient {

	@GetMapping(value = "/details")
	public List<String> getDetails();
}
