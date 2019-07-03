package com.ibm.newhire.menums.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories({"com.ibm.newhire.menums.repo"})
public class MongoDbConfiguration {
	 @Bean
	    public MongoDbFactory mongoDbFactory() throws Exception 
	    {
	        MongoClient mongoClient = new MongoClient("localhost", 27017); // connect to the database that is running in localhost 
	                                                                     // listening on port 27017
	        return new SimpleMongoDbFactory(mongoClient, "Menu"); // telling mongo the client to connect to the database server(Mongo) and the name of the database("Books") we wanna use
	    }
	 
	    @Bean
	    public MongoTemplate mongoTemplate() throws Exception 
	    {
	        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
	        return mongoTemplate;
	    }
}