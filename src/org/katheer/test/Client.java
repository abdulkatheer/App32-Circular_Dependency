package org.katheer.test;

import org.katheer.bean.Bean1;
import org.katheer.bean.Bean2;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        /*
        Circular Dependency: two or more bean objects waiting for each other.
        This occurs only in the case of constructor dependency injection.
        Reason: If a constructor needs a another bean object, the required bean will be created. But the required bean's constructor is requiring
        the other one. So no object will be created.

        This can be resolved by setter dependency injection.
        How?
        When calling setter methods, objects are created already. So there is no waiting for object creation.

        ***Order of Execution of all things up to now***
        * Object instantiation with either default constructor or parameterized constructor (i.e. constructor-arg tag
        * Object initialization
        *   property tag (i.e. via setXXX() methods
        *   BeanPostProcessor's processBeforeBeanInitialization
        *   @PostConstruct annotation's setter method
        *   InitializingBean's afterPropertiesSet() method
        *   init-method tag's method (i.e. Custom setter method)
        *   BeanPostProcessor's processAfterBean
        * Object Destroy
        *   @PreDestroy's destroy method
        *   DisposableBean's destroy method
        *   destroy-method tag's method (i.e. Custom destroy method)
         */
        AbstractApplicationContext context = new ClassPathXmlApplicationContext
                ("org/katheer/resource/applicationContext.xml");

        Bean1 bean1 = (Bean1) context.getBean("bean1");
        Bean2 bean2 = (Bean2) context.getBean("bean2");

        context.registerShutdownHook();
    }
}