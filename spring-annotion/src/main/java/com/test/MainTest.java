package com.test;

import com.test.bean.Person;
import com.test.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args){
        /*ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        Person person=(Person) applicationContext.getBean("person");
        System.out.println(person.getName());*/

       ApplicationContext applicationContext= new AnnotationConfigApplicationContext(MainConfig.class);
       Person person=applicationContext.getBean(Person.class);
       System.out.println(person.getName());
    }

}
