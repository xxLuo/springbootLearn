package com.test.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.test.bean.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile:
 *          Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
 *
 *  开发环境、测试环境、生产环境
 *  以数据源为例，(/A数据库
 *  )(/B)(/C);
 * @Profile： 指定组件在哪个环节的情况下才能被注册到容器中。不指定，任何环境下都能注册这个组件
 * 1)、加了环境标识的bean，只有这个环境被激活才能注册到容器中。默认是default环境
 */
@PropertySource("classpath:/dbconfig.properties")  //加载外部文件
/**
 * 从外部文件获取值得三种方法：
 * 1.@Value("${db.user}")
 *     private String user;
 * 2.@Value("${db.password}")String password
 * 3.EmbeddedValueResolverAware，解析器解析
 */
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {
    @Value("${db.user}")
    private String user;

    private StringValueResolver valueResolver;
    private String driverClass;

//    @Profile("test")
//    @Bean
//    Yellow yellow

    //多设置几个数据源
    @Profile("test")
    @Bean("testDataSource")    //通过@bean把数据源加入容器中
    public DataSource dataSourceTset(@Value("${db.password}")String password) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")    //通过@bean把数据源加入容器中
    public DataSource dataSourceDev() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword("123456");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ssm_crud");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword("123456");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/scw");

        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;//把解析器注入
       driverClass= valueResolver.resolveStringValue("${db.driverClass}");//解析
    }
}
