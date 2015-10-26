package com.younggit.graduation.conifg;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by lizhouyang on 15/10/21.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.younggit.graduation")
@PropertySource("classpath:orm-config.properties")
@EnableJpaRepositories("com.younggit.graduation.dao")
//@EnableSpringDataWebSupport
public class DataSourceConfig {

    private static final String DATASOURCE_DRIVER = "database.driver";
    private static final String DATASOURCE_URL = "database.url";
    private static final String DATASOURCE_USERNAME = "database.username";
    private static final String DATASOURCE_PASSWORD = "database.password";
    private static final String DATASOURCE_MAX_ACTIVE = "druid.max_active";
    private static final String DATASOURCE_INITIAL_SIZE = "druid.initial_size";

    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String HIBERNATE_BATCH_SIZE = "hibernate.jdbc.batch_size";
    private static final String HIBERNATE_PACKAGE_TO_SCAN = "hibernate.package_to_scan";


    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(DATASOURCE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(DATASOURCE_URL));
        dataSource.setUsername(env.getRequiredProperty(DATASOURCE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(DATASOURCE_PASSWORD));
        dataSource.setMaxActive(Integer.parseInt(env.getRequiredProperty(DATASOURCE_MAX_ACTIVE)));
        dataSource.setInitialSize(Integer.valueOf(env.getRequiredProperty(DATASOURCE_INITIAL_SIZE)));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(HIBERNATE_DIALECT, env.getRequiredProperty(HIBERNATE_DIALECT));
        properties.put(HIBERNATE_SHOW_SQL, env.getRequiredProperty(HIBERNATE_SHOW_SQL));
        properties.put(HIBERNATE_FORMAT_SQL, env.getRequiredProperty(HIBERNATE_FORMAT_SQL));
        properties.put(HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(HIBERNATE_HBM2DDL_AUTO));
        properties.put(HIBERNATE_BATCH_SIZE, env.getRequiredProperty(HIBERNATE_BATCH_SIZE));
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan(env.getRequiredProperty(HIBERNATE_PACKAGE_TO_SCAN));
        entityManagerFactory.setJpaProperties(hibernateProperties());
        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }

}
