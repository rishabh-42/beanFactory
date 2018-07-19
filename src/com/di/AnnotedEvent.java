package com.di;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnotedEvent {

    @EventListener
    public void onCustomEvent(NewEvent newEvent)
    {

        System.out.println("Annoted event listener");
    }
}
