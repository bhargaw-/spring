package com.sf.jpa;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource("classpath:resources/jdbc.properties")
public class Config {
	@Autowired
	private Environment environment;

	@Bean
	public DataSource getDataSournce() {
		System.out.println("data source is invoked");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(environment.getProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(environment.getProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(environment.getProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		return dataSource;
	}
	
	@Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.TRUE);
        vendorAdapter.setShowSql(Boolean.TRUE);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(environment.getProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
        factory.setDataSource(getDataSournce());
        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factory.getObject();
    }

	@Bean
	public PlatformTransactionManager  transactionManager() {
		EntityManagerFactory factory = entityManagerFactory();
        return new JpaTransactionManager(factory);
	}

	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

}
