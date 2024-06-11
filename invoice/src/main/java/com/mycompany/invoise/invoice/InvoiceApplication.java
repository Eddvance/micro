package com.mycompany.invoise.invoice;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@EntityScan("com.mycompany.invoise.entity.invoice")
@SpringBootApplication
public class InvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}

	@Bean
	public Hibernate5Module dataTypeHibernate5Module(){
		return new Hibernate5Module();
	}
////
}
