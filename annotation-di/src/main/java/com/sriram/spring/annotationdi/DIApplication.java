package com.sriram.spring.annotationdi;

import com.sriram.spring.annotationdi.configuration.DIConfiguration;
import com.sriram.spring.annotationdi.consumer.MyConsumer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DIApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(DIConfiguration.class)) {
            MyConsumer consumer = context.getBean(MyConsumer.class);
            consumer.processMessage("Hey There !", "Sam");
        }

    }
}
