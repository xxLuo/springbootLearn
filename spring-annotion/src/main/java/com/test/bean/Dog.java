package com.test.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog implements ApplicationContextAware {
    @Autowired
    private ApplicationContext applicationContext;
    public Dog(){
        System.out.println("dog ..constructor....");
    }
    //对象创建并赋值后调用
    @PostConstruct
    public void init(){
        System.out.println("dog...postconstructor");
    }
    //容器移除对象之前
    @PreDestroy
    public  void destroy(){
        System.out.println("dog..predestroy");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
