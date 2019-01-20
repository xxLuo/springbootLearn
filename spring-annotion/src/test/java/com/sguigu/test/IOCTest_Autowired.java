package com.sguigu.test;

import com.test.bean.Boss;
import com.test.bean.Car;
import com.test.bean.Color;
import com.test.config.MainConfig;
import com.test.config.MainConfigOfAutowired;
import com.test.dao.BookDao;
import com.test.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);

//        BookDao bean = applicationContext.getBean(BookDao.class);
//        System.out.println(bean);

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);

        applicationContext.close();
    }
}
