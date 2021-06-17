package br.com.zupacademy.gabrielaviana.casadocodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CasaDoCodigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasaDoCodigoApplication.class, args);
	}

}
