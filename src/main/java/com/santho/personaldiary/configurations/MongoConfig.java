package com.santho.personaldiary.configurations;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.santho.personaldiary")
@ComponentScan("com")
public class MongoConfig {
    @Bean
    MongoTemplate mongoTemplate(){
        return new MongoTemplate(MongoClients.create("mongodb://localhost:27017"),"personal_diary");
    }
}

