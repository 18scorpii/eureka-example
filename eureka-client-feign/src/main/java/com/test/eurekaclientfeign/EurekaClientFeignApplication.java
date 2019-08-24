package com.test.eurekaclientfeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class EurekaClientFeignApplication {
	@Autowired
	GreetingsInterface greetingsInterface;

	@RequestMapping(path = "get-greetings/{name}", method = RequestMethod.GET)
	public ResponseEntity getMessageFromProvider(@PathVariable("name") String name){
		return new ResponseEntity(greetingsInterface.getGreetings() + " " + name, HttpStatus.OK);
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientFeignApplication.class, args);
	}
}
