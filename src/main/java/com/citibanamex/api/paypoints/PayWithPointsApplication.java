package com.citibanamex.api.paypoints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class PayWithPointsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayWithPointsApplication.class, args);
	}
	
	@Bean
	DispatcherServlet	 dispatcherServlet () {
	    DispatcherServlet ds = new DispatcherServlet();
	    ds.setThrowExceptionIfNoHandlerFound(true);
	    return ds;
	}
}
