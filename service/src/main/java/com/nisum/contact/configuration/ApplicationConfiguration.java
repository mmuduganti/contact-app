package com.nisum.contact.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.List;

@Import({DatabaseConfiguration.class, MybatisMapperConfiguration.class, RestTemplateConfiguration.class})
@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = {"com.nisum.contact"},
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {RestController.class, Controller.class, Component.class, Repository.class})})
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    private CustomJsonHttpMessageConverter customJsonHttpMessageConverter;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        converters.addAll(Arrays.asList(customJsonHttpMessageConverter,
                new ByteArrayHttpMessageConverter(),
                new StringHttpMessageConverter(),
                new ResourceHttpMessageConverter(),
                new SourceHttpMessageConverter<Source>(),
                new AllEncompassingFormHttpMessageConverter()));
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}