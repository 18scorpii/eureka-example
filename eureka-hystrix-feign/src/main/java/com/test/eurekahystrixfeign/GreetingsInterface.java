package com.test.eurekahystrixfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "eureka-greetings-provider", fallback = GreetingsInterface.GreetingFallback.class)
public interface GreetingsInterface {
    @RequestMapping("/delayed-greetings")
    String getDelayedGreetings();

    @Component
    public static class GreetingFallback implements GreetingsInterface {
        @Override
        public String getDelayedGreetings() {
            return "Fallback Message";
        }
    }
}
