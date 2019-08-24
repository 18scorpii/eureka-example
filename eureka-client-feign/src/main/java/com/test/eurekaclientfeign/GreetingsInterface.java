package com.test.eurekaclientfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "eureka-greetings-provider")
public interface GreetingsInterface {
    @RequestMapping("/greetings")
    String getGreetings();
}
