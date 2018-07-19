package com.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mentor implements IMentor, ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;



    private String name;

    private List list;

    public void setList(List list) {
        this.list = list;
    }

    private Dependent dependent;


    @Autowired
    public void setDependent(Dependent dependent) {
        this.dependent = dependent;
    }

    public String getName() {
        return name;
    }



    @Autowired
    @Value("arpit")
    public void setName(String name) {
        this.name = name;
        System.out.println("This is " + name);

    }


    @Override
    public void getData() {
        System.out.println("This is overriden method in class");

         NewEvent newevent = new NewEvent(this);

         new Thread(()->
         {
             System.out.println("New thread started");
             publisher.publishEvent(newevent);



         }
         ).start();

       this.dependent.getData();
        list.forEach(x-> System.out.println(x));

    }


    public  void starting(){
        System.out.println("hello");
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher= applicationEventPublisher;


    }
}

