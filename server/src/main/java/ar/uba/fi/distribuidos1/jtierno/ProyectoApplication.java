package ar.uba.fi.distribuidos1.jtierno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ProyectoApplication {
	private static final Logger log = LoggerFactory.getLogger(ProyectoApplication.class);

	public static void main(String[] args) {
		java.security.Security.setProperty("networkaddress.cache.ttl" , "0");
		SpringApplication.run(ProyectoApplication.class, args);
	}


}
