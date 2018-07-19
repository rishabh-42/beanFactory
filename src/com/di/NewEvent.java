package com.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

public class NewEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public NewEvent(Object source) {
        super(source);
        System.out.println("Inside Custom Event " + source);
    }

    @Override
    public String toString() {
        return  "I am custmo eventt";
    }
}

