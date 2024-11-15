package telran.java53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories
public class EdutrekApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdutrekApplication.class, args);
		
	}

}
