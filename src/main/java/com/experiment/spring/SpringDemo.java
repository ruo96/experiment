package com.experiment.spring;

import com.experiment.spring.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.ClassUtils;

/**
 * @author wuruohong
 * @date 2022-06-15 23:48
 */
public class SpringDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DemoConfig.class);
        applicationContext.refresh();
        User user = (User) applicationContext.getBean("user");
        System.out.println("user = " + user);

        ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();
        System.out.println("beanClassLoader = " + beanClassLoader);

        System.out.println("System.getProperties().getProperty(\"name1\") = " + System.getProperties().getProperty("name1"));

        applicationContext.close();
        System.out.println("stop ok");
    }
}
