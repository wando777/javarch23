package br.edu.infnet.selllingApp;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.selllingApp.model.domain.Address;
import br.edu.infnet.selllingApp.model.domain.Seller;
import br.edu.infnet.selllingApp.model.service.SellerService;

@Order(1)
@Component
public class SellerLoader implements ApplicationRunner {

	@Autowired
	private SellerService sellerService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("inputfiles/sellers.txt");
		BufferedReader reader = new BufferedReader(file);
		String row = reader.readLine();
		String[] fields;
		while (row != null) {
			fields = row.split(";");
			Seller seller = new Seller();
			seller.setName(fields[0]);
			seller.setCpf(fields[1]);
			seller.setEmail(fields[2]);
			seller.setAddress(new Address(fields[3]));
			try {
				sellerService.put(seller);
			} catch (ConstraintViolationException e) {
				FileLogger.logException("[SELLER] " + seller + "-" + e.getMessage());
			}
			row = reader.readLine();
		}

		for (Seller seller : sellerService.getSellerList()) {
			System.out.println("seller:" + seller);
		}

		reader.close();
	}

}
