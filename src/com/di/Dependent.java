package com.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class Dependent {


    public void getData(){

        System.out.println("I'm from dependent");
    }

}
