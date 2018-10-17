package br.com.cast.castapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@EnableAutoConfiguration(exclude={
		DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class})*/
public class CastapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CastapiApplication.class, args);
	}
}
