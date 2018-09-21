package com.sriram.spring.annotationdi.service;

public class EmailService implements MessageService {
    @Override
    public boolean sendMessage(String msg, String receiver) {
        System.out.println("Send email to " + receiver + " the message : " + msg);
        return true;
    }
}
