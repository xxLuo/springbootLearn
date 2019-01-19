package com.test.config;

import com.test.bean.Color;
import com.test.bean.ColorFactoryBean;
import com.test.bean.Person;
import com.test.condition.LinuxCondition;
import com.test.condition.MyImportBeanDefinitionRegistrar;
import com.test.condition.MyImportSelector;
import com.test.condition.WindowsCondition;
import org.springframework.context.annotation.*;
//配置在类上的conditional，满足当前条件，这个类中配置的所有Bean注册才能生效
@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//@Import导入组件，ID默认是组件的全类名
public class MainConfig2 {
    /**
     *singleton默认是单实例的，ioc容器启动会调用方法创建对象放到IOC容器中，以后每次获取直接从容器拿
     *prototype,多实例，ioc容器启动并不会调用方法创建对象，而是获取方法时创建
     *使用@scope指定组件作用域，prototype多，singleton单
     * web下，request同一个请求创建一个实例，session同一个session创建一个实例
     *
     * 懒加载
     *      单实例bean，默认在容器启动时创建对象
     *      懒加载：容器启动不创建对象，第一次使用(获取)Bean创建对象，并进行初始化
    */
//    @Scope("prototype")
    @Lazy
    @Bean
    public Person person(){
        System.out.println("给容器添加Person。。");
        return new Person("zs2",21);
    }

    /**
     * @Conditional :按照一定的条件进行判断，满足条件给容器注册Bean
     *
     * 如果系统是win就注册bill，Linux就注册Linux
     */
    @Conditional({WindowsCondition.class})  //标在方法上
    @Bean("bill")
    public Person person01(){
        return new Person("Bill",62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linux")
    public Person person02(){
        return new Person("linux",56);
    }
    /**
     * 给容器注册组件的方式：
     * 1.包扫描+组件标注注解（@Controller/@Service/@Repository/@Component） 自己写的类
     * 2.@Bean[导入第三方里面的组件]
     * 3.@Import[快速给容器导入一个组件]
     *      1)@Import(要导入的组件)，id默认是全类名
     *      2)ImportSeletor:返回需要导入的全类名数组
     *      3)ImportBeanDefinitionRegistrar:手动注册Bean到容器
     *  4.使用Spring提供的FactoryBean(工厂Bean)
     *         默认获取的是调用getObject创建的对象
     *         想获取工厂Bean本身需要给id前加&
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
