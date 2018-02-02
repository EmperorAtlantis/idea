package com.oracle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.oracle")
@MapperScan(basePackages = "com.oracle.dao")
public class OaceApplication {



	public static void main(String[] args) {
		SpringApplication.run(OaceApplication.class, args);
	}
}
