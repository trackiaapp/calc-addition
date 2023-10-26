package trackia.app.example.calc.addition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"trackia.app"})
public class AdditionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdditionApplication.class, args);
	}

}
