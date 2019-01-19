package com.sguigu.test;

import com.test.bean.Blue;
import com.test.bean.Person;
import com.test.config.MainConfig;
import com.test.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest {
    @SuppressWarnings("resource")
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] definitionNames = applicationContext.getBeanDefinitionNames();
//        for(String name:definitionNames){
//            System.out.println(name);
//        }

        System.out.println("容器创建完成");
        Person person=applicationContext.getBean(Person.class);
//        Person person2=applicationContext.getBean(Person.class);
//        System.out.println(person==person2);
    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //获取环境变量的值
        String property = environment.getProperty("os.name");
        for(String name:beanNamesForType){
                System.out.println(name);
    }
    }

    @Test
    public void testImport(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }

        //工厂Bean获取的是调用getObject创建的对象
        Object bean = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型"+bean.getClass());


    }
}
