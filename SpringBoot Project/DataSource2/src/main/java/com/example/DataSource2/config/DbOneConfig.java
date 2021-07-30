package com.example.DataSource2.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "db1EntityManagerFactoryBean",
		transactionManagerRef = "db1TransactionManager",
		basePackages ="com.example.DataSource2.DbOneModels"
		)
public class DbOneConfig {
	
	//datasource
	@Bean
	@ConfigurationProperties(prefix = "db1.datasource")
	public DataSource db1DataSource() {
		
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean db1EntityManagerFactoryBean(
	EntityManagerFactoryBuilder emfb) 
	{
		HashMap<String,Object> properties =  new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		return emfb.dataSource(db1DataSource())
				.packages("com.example.DataSource2.DbOneModels")
				.properties(properties)
				.build();
		
	}
	
	@Bean
	public PlatformTransactionManager db1TransactionManager (@Qualifier("db1EntityManagerFactoryBean") EntityManagerFactory entityManagerFactory) 
	{
		return new JpaTransactionManager(entityManagerFactory);
	}
}
