package org.katheer.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Bean1 implements InitializingBean, DisposableBean {
    private Bean2 bean2;

    public Bean1() {
        System.out.println("Constructor running...");
        System.out.println("Creating object for Bean1 class...");
        System.out.println("Created object for Bean1 class...");
    }

    public Bean1(Bean2 bean2) {
        System.out.println("Creating object for Bean1 class...");
        this.bean2 = bean2;
        System.out.println("Created object for Bean1 class...");
    }

    public Bean2 getBean2() {
        return bean2;
    }

    public void setBean2(Bean2 bean2) {
        System.out.println("setXXX() running");
        this.bean2 = bean2;
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
