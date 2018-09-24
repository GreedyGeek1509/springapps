package com.sriram.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@EnableWebMvc
@Configuration
@ComponentScan({"com.sriram.spring.controller"})
@Component
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

    @Autowired
    @Qualifier("jsonConverter")
    private HttpMessageConverter jsonConverter;

    @Autowired
    @Qualifier("xmlConverter")
    private HttpMessageConverter xmlConverter;

    /** Static resource locations including themes*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**/*")
                .addResourceLocations("/", "/resources/")
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(new InternalResourceViewResolver("/WEB-INF/views/", "*.jsp"));
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jsonConverter);
        converters.add(xmlConverter);
    }
}
