package com.sriram.spring.xmldi;

import com.sriram.spring.xmldi.consumer.XMLConsumer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApplication {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("application-context.xml")) {
            XMLConsumer consumer = (XMLConsumer) context.getBean("xmlConsumer");
            consumer.processMessage("Hey Spring", "Spring Team");
        }

    }
}
