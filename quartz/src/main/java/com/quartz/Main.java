package com.quartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		/**
		 * 初始化Spring容器
		 */
		new ClassPathXmlApplicationContext("classpath:applicationContext-scheduler.xml");
	}

}
