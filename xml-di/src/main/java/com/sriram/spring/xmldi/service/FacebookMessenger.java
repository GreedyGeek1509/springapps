package com.sriram.spring.xmldi.service;

public class FacebookMessenger implements MessageService {
    @Override
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Sending Facebook message to : " + rec + " message : " + msg);
        return true;
    }
}
