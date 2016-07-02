package com.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.core.Bike;
import com.spring.core.Car;
import com.spring.core.Tyre;
import com.spring.core.Vehical;

@Configuration
public class AppConfig {

	@Bean
	public Vehical getCarObect(){
		return new Car();
	}
	
	@Bean
	public Vehical getBikeObject(){
		return new Bike();
	}
	
	@Bean
	public Tyre getTireObject(){
		return new Tyre();
	}
}
