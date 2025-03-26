package com.vinsguru.graphqlplayground.lec07.config;


import com.vinsguru.graphqlplayground.lec07.service.CustomerOrderDataFetcher;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.util.Map;

@Configuration
public class DataFetchWiringConfig {

    @Autowired
    private CustomerOrderDataFetcher dataFetcher;

    @Bean
    public RuntimeWiringConfigurer configurer() {
        return c -> c.type("Query", b -> b.dataFetchers(map()));
    }

    private Map<String, DataFetcher> map() {
        return Map.of(
                "customers", dfe -> "s",
                "age", dfe -> 12,
                "city", dfe -> "atlanta"
        );
    }
}
