package com.sriram.spring.annotationdi.configuration;

import com.sriram.spring.annotationdi.service.EmailService;
import com.sriram.spring.annotationdi.service.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.sriram.spring.annotationdi.consumer"})
public class DIConfiguration {

    @Bean
    public MessageService getMessageService() {
        return new EmailService();
    }
}
