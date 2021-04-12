package com.course.springboot.controllers.springbootcontrollers.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.course.springboot"})
public class Application {

	public static void main(String[] args){
		new SpringApplication(Application.class).run();
	}

}
