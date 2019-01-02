package pl.piomin.services.circuitBraker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix
@RestController
@EnableHystrixDashboard
public class CircuitBrakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBrakerApplication.class, args);
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getTemplate()
	{
		return new RestTemplate();
	}
	
	@RequestMapping(value="/circuit-employee",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="fallbackEmployee")
	public String circuitBreaker()
	{
		return this.restTemplate.getForObject("http://localhost:8090/", String.class);
		
	}
	
	public String fallbackEmployee()
	{
		return "Oops..!sorry for delay..Try after sometime";
	}

}

