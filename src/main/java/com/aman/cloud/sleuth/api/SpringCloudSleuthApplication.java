package com.aman.cloud.sleuth.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@RestController
public class SpringCloudSleuthApplication {
	
	private static final Logger log=LoggerFactory.getLogger(SpringCloudSleuthApplication.class);
	
	@Autowired
	private RestTemplate template;
	
	
	@GetMapping("/getDiscount")
	public String discount(){
		log.info("discounted service called in java .....");
		return "added discount 15%";
	}
	
	@GetMapping("/payment")
	public String payment() {
		log.info("payment service called with ");
		return template.getForObject("http://localhost:8081/getDiscount", String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSleuthApplication.class, args);
	}

}
