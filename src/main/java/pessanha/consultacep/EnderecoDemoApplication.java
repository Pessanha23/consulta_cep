package pessanha.consultacep;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Consulta cep API", version = "2.0", description = "endereco"))
public class EnderecoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnderecoDemoApplication.class, args);
	}

}
