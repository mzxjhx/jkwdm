package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @SpringBootApplication：标注一个主程序类，用来标明这是一个Spring Boot应用

@SpringBootApplication
@MapperScan({"com.jmwdm.*.dao"})
public class SpringBootApplicationMain {
    // Spring应用启动起来
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationMain.class, args);
    }
}
 */

@SpringBootApplication
@MapperScan({"com.jmwdm.*.dao"})
public class SpringBootApplicationMain extends SpringBootServletInitializer{
	 
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(SpringBootApplicationMain.class);
	}
 
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationMain.class, args);
	}
	
 
 
}
