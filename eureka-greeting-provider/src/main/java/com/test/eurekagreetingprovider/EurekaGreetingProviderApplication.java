package com.test.eurekagreetingprovider;

import com.netflix.discovery.EurekaClient;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.ServerSocket;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaGreetingProviderApplication {

	private static int PORT = 0;

	@Autowired
	EurekaClient eurekaClient;

	@Value("${spring.application.name}")
	String applicationName;

	@RequestMapping(path = "/greetings", method = RequestMethod.GET)
	public ResponseEntity<String> getGreetings(){
		String appName = eurekaClient.getApplication(applicationName).getName();
		return new ResponseEntity<String>(String.format("Welcome message from %s[%d]", appName, PORT), HttpStatus.OK);
	}

	@RequestMapping(path = "/delayed-greetings", method = RequestMethod.GET)
	public ResponseEntity<String> getDelayedGreetings(){
		String appName = eurekaClient.getApplication(applicationName).getName();
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(String.format("Delayed Welcome message from %s[%d]", appName, PORT), HttpStatus.OK);
	}

	private static int getRandomPort(){
		try(ServerSocket socket = new ServerSocket(0)){
			PORT = socket.getLocalPort();
		}catch (Exception exp){
		}
		return PORT;
	}

	public static void main(String[] args) {
		System.getProperties().put("server.port", getRandomPort());
		SpringApplication.run(EurekaGreetingProviderApplication.class, args);
	}

}
