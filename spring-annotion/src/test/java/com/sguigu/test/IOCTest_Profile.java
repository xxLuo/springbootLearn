package com.sguigu.test;

import com.test.config.MainConfigOfAutowired;
import com.test.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {

    //1>使用命令行动态参数：在虚拟机参数位置加上： -Dspring.profiles.active=test
    @Test
    public  void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for(String string:namesForType){
            System.out.println(string);
        }
        applicationContext.close();
    }

    //2.
    @Test
    public  void test02() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        //1.创建一个
        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for(String string:namesForType){
            System.out.println(string);
        }
        applicationContext.close();
    }
}
