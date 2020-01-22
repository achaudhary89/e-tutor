package com.alok.mytutorwebapp.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean(){

        System.out.println("LifeCycleDemoBean constructor called");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory called ");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy called..");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet called ");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("setApplicationContext called");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("PostConstruct method annotation called");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy method called");
    }

    public void beforeInit(){
        System.out.println("beforeInit method called");
    }

    public void afterInit(){
        System.out.println("afterInit method called");
    }
}
