package com.nisum.contact.configuration;

import com.nisum.contact.profiles.LiveResourcesProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@LiveResourcesProfile
@Configuration
@Import(ApplicationProperties.class)
public class DatabaseConfiguration {

    private @Value("${tradestone.jdbc.driver}") String driverClassName;
    private @Value("${tradestone.jdbc.url}") String url;
    private @Value("${tradestone.jdbc.username}") String username;
    private @Value("${tradestone.jdbc.password}") String password;

    @Bean(name="dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();

        datasource.setDriverClassName(driverClassName);
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);

        return datasource;
    }
}
