package com.cheung.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTwo {

	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println(ac);
	}
}
