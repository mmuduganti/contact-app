package com.nisum.contact.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Import({DatabaseConfiguration.class, TestDatabaseConfiguration.class, MybatisMapperConfiguration.class, RestTemplateConfiguration.class})
@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {"com.nisum.contact"},
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class, Component.class, Repository.class})})
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {


}