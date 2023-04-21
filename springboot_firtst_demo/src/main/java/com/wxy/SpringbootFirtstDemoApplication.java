package com.wxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class SpringbootFirtstDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirtstDemoApplication.class, args);
	}

}
