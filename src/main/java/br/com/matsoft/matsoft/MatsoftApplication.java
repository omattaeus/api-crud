package br.com.matsoft.matsoft;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@OpenAPIDefinition(info = @Info(title = "matsoft", version = "1", description = "API desenvolvida para estudos"))
public class MatsoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatsoftApplication.class, args);
	}

}
