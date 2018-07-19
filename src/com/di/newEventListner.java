package com.di;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class newEventListner implements ApplicationListener<NewEvent> {
    @Override
    public void onApplicationEvent(NewEvent event) {
        System.out.println("i'm from new Event : " + event.toString());
    }
}

