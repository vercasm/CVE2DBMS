package net.Vercasm;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories("net.Vercasm.Repositories")
public class Json2DbServiceApplication {


	public static void main(String[] args) {
	//	RuntimeChecks rc = new RuntimeChecks();
		SpringApplication.run(Json2DbServiceApplication.class, args);
	}

}
