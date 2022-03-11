package com.foodorderingapplication.FoodOrderApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


public class SwaggerConfig {

//	
//	public Docket Api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.foodorderingapplication.FoodOrderApp"))
//				.paths(PathSelectors.any())
//				.build()
//				.pathMapping("/")
//				.apiInfo(apiInfo());
//	}
//	
//	
//	private ApiInfo apiInfo() {
//	    return new ApiInfoBuilder()
//	    		.title("Food Ordering App")
//	    		.description("APIs for ordering food items online ")
//	    		.build();
//	 
//	}
//	
	
	
}
