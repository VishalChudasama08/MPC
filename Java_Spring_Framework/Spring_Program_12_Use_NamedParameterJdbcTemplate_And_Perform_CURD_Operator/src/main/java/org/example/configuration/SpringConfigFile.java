package org.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfigFile {
    @Bean
    public DriverManagerDataSource myDriverManager(){ // this method you have also known as connection method, store all information on database connectivity
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost@root:3306/spring_jdbc_db");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate myNameParameterJdbcTem(){
//        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(myDriverManager());
        // object banav vani jarur nathi, tethi direct class return karel chhe (with it constructor argument -> myDriverManager())
        return new NamedParameterJdbcTemplate(myDriverManager());
    }
}
