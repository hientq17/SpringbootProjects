package edu.fpt.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.ResourceBundle;

@Configuration
@EntityScan(basePackages = {"edu.fpt.entity"})
@EnableJpaRepositories(basePackages = {"edu.fpt.repository"})
@EnableTransactionManagement
public class JPAConfig {

    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPersistenceUnitName("persistence-data");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(resourceBundle.getString("driverName"));
        dataSource.setUrl(resourceBundle.getString("url"));
        dataSource.setUsername(resourceBundle.getString("user"));
        dataSource.setPassword(resourceBundle.getString("password"));
        return dataSource;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        //prevent insert/update on database
		properties.setProperty("hibernate.hbm2ddl.auto", "none");
        //enable lazy loading
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "update");
        return properties;
    }
}
