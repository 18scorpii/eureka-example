- [Eureka Server](http://localhost:8086/)

- [Fegin Client Using Eureka LB](http://localhost:8082/get-greetings/kamal)

- [Zuul Proxy To Call Delayed Greetings](http://localhost:8083/a/delayed-greetings)

- [Zuul Proxy To Call Advices](http://localhost:8083/b/advises)

- [Call Advice End Point Directly](http://localhost:8085/advises)
    - [Add Advices from this list to DB](https://www.inc.com/lolly-daskal/25-excellent-pieces-of-advice-that-most-people-ignore.html)
   
- [Call Hystrix Based Feign Client on Greetings](http://localhost:8081/get-greetings/priya)

- [Hystrix Dashboard](http://localhost:8087/hystrix/)
    - To load Zuul add localhost:8083/actuator/hystrix.stream
    - To add Feign add localhost:8081/actuator/hystrix.stream
    
- To start all services, using Run Dashboard.
    - Greetings Services can be started any number of times.