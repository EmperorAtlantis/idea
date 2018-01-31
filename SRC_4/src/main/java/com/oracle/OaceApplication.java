package com.oracle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.oracle.mapper")
public class OaceApplication {



	public static void main(String[] args) {
		SpringApplication.run(OaceApplication.class, args);
	}
}
