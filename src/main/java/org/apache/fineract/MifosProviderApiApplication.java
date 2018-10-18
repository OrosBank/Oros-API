package org.apache.fineract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.apache.fineract")
public class MifosProviderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MifosProviderApiApplication.class, args);
	}
}
