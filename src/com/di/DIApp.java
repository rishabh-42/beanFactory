package com.di;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class DIApp {

     public static void main(String[] args) throws SQLException {


         // Initialise Context
        ApplicationContext context = new ClassPathXmlApplicationContext("com/di/beanConfiguration.xml");

        ((ClassPathXmlApplicationContext) context).start();
//         ApplicationContext context = new AnnotationConfigApplicationContext(Class.class);// Class-> @configuration wali class



       //Define Bean in config
        Mentor mentor = (Mentor) context.getBean("mentor");
        mentor.getData();
       // ((ClassPathXmlApplicationContext) context).close();

         jdbc jjdbc = (jdbc) context.getBean("jdbc");

         jjdbc.getUserData();
         Collection<details> de = jjdbc.getSaradata();

         Iterator<details> i = de.iterator();





//
//String det = jjdbc.getdata();


        //Get bean from controller
    }


}
