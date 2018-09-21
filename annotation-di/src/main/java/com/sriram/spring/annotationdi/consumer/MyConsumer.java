package com.sriram.spring.annotationdi.consumer;

import com.sriram.spring.annotationdi.service.MessageService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Setter(onMethod = @__({@Autowired}))
public class MyConsumer {
    private MessageService messageService;

    public boolean processMessage(String msg, String rec) {
        return messageService.sendMessage(msg, rec);
    }
}
