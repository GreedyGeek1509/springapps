package com.sriram.spring.annotationdi;

import com.sriram.spring.annotationdi.consumer.MyConsumer;
import com.sriram.spring.annotationdi.service.MessageService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.sriram.spring.annotationdi.consumer"})
public class DITest {
    private AnnotationConfigApplicationContext context;
    private MyConsumer consumer;

    @Bean
    public MessageService getMessageService() {
        return ((msg, receiver) -> {
            System.out.println("Sending Test Message : " + msg + " to :" + receiver);
            return true;
        });
    }

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(DITest.class);
        consumer = context.getBean(MyConsumer.class);
    }

    @After
    public void tearDown() {
        context.close();
    }

    @Test
    public void testDI() {
        Assert.assertTrue("process message returned false,", consumer.processMessage("Hello", "Sriram"));
    }
}
