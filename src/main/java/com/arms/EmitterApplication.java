package com.arms;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmitterApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EmitterApplication.class, args);
		
		System.out.println("Let's see the list of Beans created by Spring");
		
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
