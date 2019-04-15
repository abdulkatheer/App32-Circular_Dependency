package org.katheer.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Bean2 implements InitializingBean, DisposableBean {
    private Bean1 bean1;

    public Bean2() {
        System.out.println("Constructor running...");
        System.out.println("Creating object for Bean2 class...");
        System.out.println("Created object for Bean2 class...");
    }

    public Bean2(Bean1 bean1) {
        System.out.println("Creating object for Bean1 class...");
        this.bean1 = bean1;
        System.out.println("Created object for Bean2 class...");
    }

    public Bean1 getBean1() {
        return bean1;
    }

    public void setBean1(Bean1 bean1) {
        System.out.println("setXXX() running");
        this.bean1 = bean1;
    }

    public void customInit() {
        System.out.println("customInit() running...");
    }

    @PostConstruct
    public void annotationInit() {
        System.out.println("@PostConstruct's setter running...");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean's destroy method running...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean's afterPropertiesSet() method running...");
    }

    @PreDestroy
    public void annotationDestroy() {
        System.out.println("@PreDestroy's destroy method running...");
    }

    public void customDestroy() {
        System.out.println("customDestroy() method running...");
    }
}
