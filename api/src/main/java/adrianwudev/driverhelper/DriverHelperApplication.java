package adrianwudev.driverhelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ApplicationConfig.class)
public class DriverHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverHelperApplication.class, args);
	}

}
