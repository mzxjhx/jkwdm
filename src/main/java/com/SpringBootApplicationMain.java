package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;


@SpringBootApplication(exclude = PageHelperAutoConfiguration.class)
@MapperScan({"com.jmwdm.*.dao"})
//@ComponentScan(basePackages= {"com.jmwdm.framework"})
@ServletComponentScan
public class SpringBootApplicationMain extends SpringBootServletInitializer{
	 
	/**
	 * 以war包形式部署到tomcat，需要继承SpringBootServletInitializer
	 */
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(SpringBootApplicationMain.class);
	}
 
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationMain.class, args);
	}
}
