package com.test.eurekahystrixfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients
@RestController
public class EurekaHystrixFeignApplication {
	@Autowired
	GreetingsInterface greetingsInterface;

	@RequestMapping(path = "get-greetings/{name}", method = RequestMethod.GET)
	public ResponseEntity getMessageFromProvider(@PathVariable("name") String name){
		return new ResponseEntity(greetingsInterface.getDelayedGreetings() + " from Hystrix Feign Client for "+name, HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaHystrixFeignApplication.class, args);
	}

}
