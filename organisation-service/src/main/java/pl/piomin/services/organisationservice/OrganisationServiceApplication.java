package pl.piomin.services.organisationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
public class OrganisationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganisationServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerapidocument()
	{
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("pl.piomin.services.organisationservice")).paths(PathSelectors.any()).build().apiInfo(new ApiInfoBuilder().version("1.0").title("organisation APi").description("Documentation organisation API v1.0").build());
		
	}
	
}
