package rest.Rest_Beginning;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QApplication {

	public static void main(String[] args) {
		SpringApplication.run(QApplication.class, args);
		System.out.println("This is Spring Boot");
	}

	@Bean
	public ModelMapper getModelMapper(){
		return  new ModelMapper();
	}
}
