package com.sguigu.test;

import com.test.bean.Person;
import com.test.config.MainConfigOfLifeCycle;
import com.test.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest_PropertyValue {
    //1.创建IOC容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);

    @Test
    public void test01(){
        printBeans(applicationContext);
        System.out.println("======");

        Person person=(Person)applicationContext.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property=environment.getProperty("person.nickName");
        System.out.println(property);
        //关闭容器
        applicationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }
    }
}
