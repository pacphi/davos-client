package io.pivotal.davos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import reactivefeign.spring.config.EnableReactiveFeignClients;

@ConfigurationPropertiesScan
@EnableReactiveFeignClients
@SpringBootApplication
public class DavosClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DavosClientApplication.class, args);
	}

}
