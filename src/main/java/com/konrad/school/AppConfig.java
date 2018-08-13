package com.konrad.school;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan(basePackages = "com.konrad.school")
//@EnableWebMvc
public class AppConfig {
    @Autowired
    private Environment env;
    @Bean
    public DataSource securityDataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        comboPooledDataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        comboPooledDataSource.setUser(env.getProperty("spring.datasource.username"));
        comboPooledDataSource.setPassword(env.getProperty("spring.datasource.password"));
        comboPooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        comboPooledDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        comboPooledDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        comboPooledDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
        return comboPooledDataSource;
    }

    private int getIntProperty(String propName) {
        String propVal = env.getProperty(propName);
        int intPropVal = Integer.parseInt(propVal);
        return intPropVal;
    }
}
