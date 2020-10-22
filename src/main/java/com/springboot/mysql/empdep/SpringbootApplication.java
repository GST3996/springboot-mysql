package com.springboot.mysql.empdep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.springboot.mysql.empdep.ctrl" ,"com.springboot.mysql.empdep.exception","com.springboot.mysql.empdep.entity","com.springboot.mysql.empdep.repository","com.springboot.mysql.empdep.service"})
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
