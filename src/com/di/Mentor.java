package com.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;


public class Mentor implements IMentor {

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


    @Required
    @Autowired
    @Value("arpit")
    public void setName(String name) {
        this.name = name;
        System.out.println("This is " + name);

    }


    @Override
    public void getData() {
        System.out.println("This is overriden method in class");

       this.dependent.getData();
        list.forEach(x-> System.out.println(x));
    }


    public  void starting(){
        System.out.println("hello");
    }


}

