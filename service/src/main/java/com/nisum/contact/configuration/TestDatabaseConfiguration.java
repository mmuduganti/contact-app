package com.nisum.contact.configuration;

import com.nisum.contact.profiles.InternalResourcesProfile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

@Configuration
@InternalResourcesProfile
public class TestDatabaseConfiguration {

    @Bean(name="dataSource")
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.addScript("schema.sql").addScript("test-data.sql").build();
    }
}
