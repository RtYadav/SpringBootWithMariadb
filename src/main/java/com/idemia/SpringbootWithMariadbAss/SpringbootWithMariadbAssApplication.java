package com.idemia.SpringbootWithMariadbAss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.*;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class SpringbootWithMariadbAssApplication {


    public static void main(String[] args) {
		SpringApplication.run(SpringbootWithMariadbAssApplication.class, args);
		System.out.println("In main");


	}
	/*@Bean
	public DataSource createDatasource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(uname);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);

        return  dataSource;
    }
*/



}
