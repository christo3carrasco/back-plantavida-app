package com.plantavida.back.infrastructure;

import com.plantavida.back.domain.entities.Event;
import com.plantavida.back.domain.entities.Role;
import com.plantavida.back.domain.entities.User;
import com.plantavida.back.domain.entities.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.plantavida.back.infrastructure.repositories")
public class PlantaVidaInfrastructureConfig {
    private static final String HIB_SHOW_SQL = "hibernate.show_sql";

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSourse() {
        DriverManagerDataSource dataSourse = new DriverManagerDataSource();
        dataSourse.setDriverClassName(Objects.requireNonNull(env.getProperty("db.driver")));
        dataSourse.setUrl(env.getProperty("db.url"));
        dataSourse.setUsername(env.getProperty("db.username"));
        dataSourse.setPassword(env.getProperty("db.password"));
        return dataSourse;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSourse());

        entityManagerFactory.setPackagesToScan(Event.class.getPackage().getName());
        entityManagerFactory.setPackagesToScan(Role.class.getPackage().getName());
        entityManagerFactory.setPackagesToScan(User.class.getPackage().getName());
        entityManagerFactory.setPackagesToScan(Volunteer.class.getPackage().getName());

        HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
        hibernateJpa.setDatabase(Database.POSTGRESQL);
        hibernateJpa.setDatabasePlatform(env.getProperty("hibernate.dialect"));
        hibernateJpa.setGenerateDdl(Boolean.TRUE.equals(env.getProperty("hibernate.generateDdl", Boolean.class)));
        hibernateJpa.setShowSql(Boolean.TRUE.equals(env.getProperty(HIB_SHOW_SQL, Boolean.class)));
        entityManagerFactory.setJpaVendorAdapter(hibernateJpa);

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        jpaProperties.put(HIB_SHOW_SQL, env.getProperty(HIB_SHOW_SQL));
        jpaProperties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        entityManagerFactory.setJpaProperties(jpaProperties);
        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}
