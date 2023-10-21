package br.edu.infnet.selllingApp;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.selllingApp.model.domain.Clothing;
import br.edu.infnet.selllingApp.model.domain.ClothingSize;
import br.edu.infnet.selllingApp.model.service.ClothingService;

@Order(3)
@Component
public class ClothingLoader implements ApplicationRunner {

	@Autowired
	private ClothingService clothingService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("inputfiles/clothes.txt");
		BufferedReader reader = new BufferedReader(file);
		String row = reader.readLine();
		String[] fields;
		while (row != null) {
			fields = row.split(";");
			Clothing clothing = new Clothing();
			clothing.setId(Integer.valueOf(fields[0]));
			clothing.setDescription(fields[1]);
			clothing.setPrice(Float.valueOf(fields[2]));
			clothing.setHasStock(Boolean.valueOf(fields[3]));
			clothing.setBrand(fields[4]);
			clothing.setSize(ClothingSize.valueOf(fields[5]));
			clothing.setColor(fields[6]);

			clothingService.put(clothing);
			row = reader.readLine();
		}

		for (Clothing clothing : clothingService.getClothingList()) {
			System.out.println("Clothing:" + clothing);
		}

		reader.close();
	}

}
