package com.thoughtworks.dependencydemoapp;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyDemoAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(DependencyDemoAppApplication.class, args);
	}

}
