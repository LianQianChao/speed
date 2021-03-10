package org.app.speed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("org.app.speed.mapper")
@EnableTransactionManagement
public class SpeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeedApplication.class, args);
	}

}
