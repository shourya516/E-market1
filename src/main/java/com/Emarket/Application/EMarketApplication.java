package com.Emarket.Application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages ="com.Emarket")
public class EMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(EMarketApplication.class, args);

	}

}
