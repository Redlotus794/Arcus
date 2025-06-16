package com.rdlts.arcus.scak.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ArcusScakGatewwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArcusScakGatewwayApplication.class, args);
	}

}
