package org.springframework.samples.fightclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication(proxyBeanMethods = false)
public class SpringFightclubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFightclubApplication.class, args);
	}

}
