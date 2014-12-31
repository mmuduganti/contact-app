package com.nisum.contact.configuration;

import com.nisum.contact.profiles.LiveResourcesProfile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

@LiveResourcesProfile
@Configuration
@Import(ApplicationProperties.class)
public class DatabaseConfiguration {

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.addScript("schema.sql").build();
    }
}
