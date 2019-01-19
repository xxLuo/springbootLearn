package com.test.bean;

import org.springframework.beans.factory.FactoryBean;

//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {
    public ColorFactoryBean() {
        super();
    }

    public Color getObject() throws Exception {
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    //是单例吗?true，则是单例
    public boolean isSingleton() {
        return true;
    }
}
