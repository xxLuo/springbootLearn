package com.test.condition;

import com.test.bean.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * annotationMetadata:当前类的注解信息
     * BeanDefinitionRegistry：BeanDefinition注册类
     *    把所有要添加到容器中的Bean 调用
     *    BeanDefinitionRegistry.regusterBeanDefinition手工注册

     */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean definition = beanDefinitionRegistry.containsBeanDefinition("com.test.bean.Red");
        boolean definition2 = beanDefinitionRegistry.containsBeanDefinition("com.test.bean.Blue");
        if(definition&&definition2){
            //指定bean定义信息
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Rainbow.class);
            //注册一个bean，指定bean名
            beanDefinitionRegistry.registerBeanDefinition("rainBow",beanDefinition);
        }

    }
}
