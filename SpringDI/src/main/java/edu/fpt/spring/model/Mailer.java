package edu.fpt.spring.model;

import org.springframework.stereotype.Component;

@Component("mailer")
public class Mailer {
    public void send(String message){
        System.out.println("Message "+message + " sent!");
    }
}
