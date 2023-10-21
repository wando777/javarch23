package br.edu.infnet.selllingApp;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.selllingApp.model.domain.Seller;

@Order(1)
@Component
public class SellerLoader implements ApplicationRunner {

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
			System.out.println("seller:" + seller);
			row = reader.readLine();
		}
		reader.close();
	}

}
