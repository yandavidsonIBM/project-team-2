//package com.ibm.newhire.orderms.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
// 
//import com.mongodb.MongoClient;
// 
//@Configuration
//@EnableMongoRepositories({ "com.ibm.newhire.orders.repo" })
//public class MongoDbConfiguration 
//{ 
//    @Bean
//    public MongoDbFactory mongoDbFactory() throws Exception 
//    {
//        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        return new SimpleMongoDbFactory(mongoClient, "Orders");
//    }
// 
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception 
//    {
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
//        return mongoTemplate;
//    }
//}
