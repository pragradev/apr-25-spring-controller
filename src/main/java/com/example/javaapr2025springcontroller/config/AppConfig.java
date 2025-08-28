package com.example.javaapr2025springcontroller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Autowired
    DataSource dataSource;

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public DataSource dataSource(){
//        DataSource build = DataSourceBuilder.create().url("jdbc:h2:mem:appdb").username("sa").password("sa123").build();
//        return build;
//    }
}
