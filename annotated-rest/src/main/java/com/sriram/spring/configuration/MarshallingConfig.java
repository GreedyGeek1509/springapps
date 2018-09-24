package com.sriram.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {WebMvcConfigurerImpl.class})
public class MarshallingConfig {
    @Bean(name = "jsonConverter")
    public HttpMessageConverter jsonConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    @Bean(name = "xmlConverter")
    public HttpMessageConverter xmlConverter() {
        return new Jaxb2RootElementHttpMessageConverter();
    }
}
