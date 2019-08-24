package com.test.eurekaadviseprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class EurekaAdviseProviderApplication {

	@GetMapping("/advise")
	public String getAdvise(){
		return "Take time to know yourself";
	}
	@GetMapping("/advises")
	public ResponseEntity<List<String>> getAdvises(){
		List<String> advices = Arrays.asList("Don't make assumptions", "Luck comes from hard work");
		return new ResponseEntity<List<String>>(advices, HttpStatus.OK);
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaAdviseProviderApplication.class, args);
	}

}
