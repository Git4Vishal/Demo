package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties // Tells spring that we want to map properties to POJO
public class DemoApplication {
	
	@Value("${configuration.projectName}")
	void setProjectName(String projectName) {
		System.out.println("setting project Name: " + projectName);
	}
	
	@Autowired
	void setEnvironment(Environment env) {
		System.out.println("setting environment: " + env.getProperty("configuration.projectName"));
	}
	
	@Autowired
	void setConfigurationProjectProperties(ConfigurationProject cp) {
		System.out.println("configurationProjectProperties.projectName: " + cp.getProjectName());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}