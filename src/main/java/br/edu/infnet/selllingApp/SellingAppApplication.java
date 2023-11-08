package br.edu.infnet.selllingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SellingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellingAppApplication.class, args);
	}

}
