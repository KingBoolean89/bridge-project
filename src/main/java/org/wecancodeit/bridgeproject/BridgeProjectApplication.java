package org.wecancodeit.bridgeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BridgeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BridgeProjectApplication.class, args);
		System.out.println("Server Is Running");
	}
}
