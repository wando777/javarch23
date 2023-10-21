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
import br.edu.infnet.selllingApp.model.domain.Product;
import br.edu.infnet.selllingApp.model.service.ProductService;

@Order(2)
@Component
public class ProductLoader implements ApplicationRunner {

	@Autowired
	private ProductService productService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("inputfiles/products.txt");
		BufferedReader reader = new BufferedReader(file);
		String row = reader.readLine();
		String[] fields;
		while (row != null) {
			fields = row.split(";");
			switch (fields[fields.length-1]) {
			case "C":
				Clothing clothing = new Clothing();
				clothing.setId(Integer.valueOf(fields[0]));
				clothing.setDescription(fields[1]);
				clothing.setPrice(Float.valueOf(fields[2]));
				clothing.setHasStock(Boolean.valueOf(fields[3]));
				clothing.setBrand(fields[4]);
				clothing.setSize(ClothingSize.valueOf(fields[5]));
				clothing.setColor(fields[6]);

				productService.put(clothing);
				break;
			case "T":

				break;

			default:
				break;
			}

			row = reader.readLine();
		}

		for (Product product : productService.getProductList()) {
			System.out.println("product:" + product);
		}

		reader.close();
	}

}
