package com.demo;

import FactoryBean.CarFactoryBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Car;
import pojo.User;

public class JunitTest {
    /**
     * 1. 测试自定义标签功能
     */
    @Test
    public void testCustomTag(){
        ApplicationContext bf = new ClassPathXmlApplicationContext("spring-user.xml");
        User user = (User) bf.getBean("userBean");
        System.out.println(user.getUserName()+","+user.getEmail());
    }

    /**
     * 2. 测试FactoryBean
     */
    @Test
    public void testFactoryBean(){
        ApplicationContext bf = new ClassPathXmlApplicationContext("spring-car.xml");
        Car car = (Car) bf.getBean("car");
        CarFactoryBean carFactoryBean = (CarFactoryBean)bf.getBean("&car");
        System.out.println(car);
        System.out.println(carFactoryBean instanceof CarFactoryBean);
    }
}
