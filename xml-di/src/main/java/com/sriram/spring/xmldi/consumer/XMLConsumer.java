package com.sriram.spring.xmldi.consumer;

import com.sriram.spring.xmldi.service.MessageService;
import lombok.Setter;

@Setter
public class XMLConsumer {
    private MessageService messageService;

    public boolean processMessage(String msg, String rec) {
        return messageService.sendMessage(msg, rec);
    }
}
