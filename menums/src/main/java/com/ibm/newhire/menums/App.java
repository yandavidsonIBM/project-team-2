package com.ibm.newhire.menums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.ibm.newhire.menums.App;

@SpringBootApplication
@EnableAutoConfiguration
public class App extends SpringBootServletInitializer 
{
    public static void main( String[] args ) throws Exception 
    {
    	SpringApplication.run(App.class, args);
    }
}