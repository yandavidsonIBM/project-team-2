package com.ibm.newhire.orderms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication   
@EnableMongoRepositories(basePackageClasses = OrderApplication.class)
public class OrderApplication extends SpringBootServletInitializer  {
    public static void main(String[] args) throws Exception 
	{
        SpringApplication.run(OrderApplication.class, args);
    }
}
