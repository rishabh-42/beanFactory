package com.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIApp {

     public static void main(String[] args) {


         // Initialise Context
       // ApplicationContext context = new ClassPathXmlApplicationContext("com/di/beanConfiguration.xml");

         ApplicationContext context = new AnnotationConfigApplicationContext(Class.class);// Class-> @configuration wali class



       //Define Bean in config
        Mentor mentor = (Mentor) context.getBean("mentor");
        mentor.getData();
       // ((ClassPathXmlApplicationContext) context).close();








        //Get bean from controller
    }


}
