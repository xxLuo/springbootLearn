package com.test.config;

import com.test.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//配置类=以前的配置文件
@Configuration  //告诉spring这是一个配置类
@ComponentScan(value = "com.test")   //也可以用excludeFilters=Filter[]排除n哪些组件，filter按照哪种规则扫描
//使用只包含include，得禁用默认usedefaultFilters
//componentscans是componentscan数组，可以多指定规则
//FilterType.ANNOTATION:按照注解
//FilterType.ASSIGNABLETYPE：按照给定的类型
//FilterType.CUSTOM：使用自定义规则
public class MainConfig {
    //给容器中注册一个Bean，类型为返回值的类型密度默认是方法名作为id
    @Bean
    public Person person(){
        return new Person("lisi",23);
    }
}
